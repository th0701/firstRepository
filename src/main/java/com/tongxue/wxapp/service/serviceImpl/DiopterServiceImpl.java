package com.tongxue.wxapp.service.serviceImpl;

import com.tongxue.wxapp.config.MyException;
import com.tongxue.wxapp.dao.DiopterMapper;
import com.tongxue.wxapp.pojo.Diopter;
import com.tongxue.wxapp.pojo.Product;
import com.tongxue.wxapp.service.DiopterService;
import com.tongxue.wxapp.service.ProductService;
import com.tongxue.wxapp.service.Product_colorService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class DiopterServiceImpl implements DiopterService {
    @Resource
    private DiopterMapper diopterMapper;
    @Resource
    private Product_colorService product_colorService;
    @Resource
    private ProductService productService;

    @Override
    public int addDiopter(Diopter diopter) {
        return diopterMapper.addDiopter(diopter);
    }

    @Override
    public List<Diopter> selectList() {
        return diopterMapper.selectList();
    }

    @Override
    public int selectStock(Integer product_id, Integer pd_colorId, String diopterName) {
        Integer i = diopterMapper.selectStock(product_id, pd_colorId, diopterName);
        if (i == null) {
            i = 0;
        }
        return i;
    }

    @Override
    @Transactional
    public int addDiopterList(List<Diopter> list) {
        return diopterMapper.addDiopterList(list);
    }

    @Override
    public int deletePdDiopter(Integer id) {
        return diopterMapper.deletePdDiopter(id);
    }

    @Override
    public List<Diopter> selectAllDiopter(Integer id) {
        return diopterMapper.selectAllDiopter(id);
    }

    @Override
    public int deleteDiopter(Integer id) {
        return diopterMapper.deleteDiopter(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public boolean batchImport(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;
        List<Diopter> diopters = new ArrayList<>();
        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new MyException("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet != null) {
            notNull = true;
        }
        Diopter diopter;
        for (int r = 1; r <= sheet.getLastRowNum(); r++) {//r = 1 表示从第二行开始循环 如果你的第三行开始是数据
            Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
            if (row == null) {
                continue;
            }
            //sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException
            diopter = new Diopter();
            if (row.getCell(0).getCellType() != 1) {//循环时，得到每一行的单元格进行判断
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名请设为文本格式)");
            }
            String product_name = row.getCell(0).getStringCellValue();//得到每一行第一个单元格的值
            if (product_name == null || product_name.isEmpty()) {//判断是否为空
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名请设为文本格式)");
            }
            row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第二个单元格的值
            String pd_colorName = row.getCell(1).getStringCellValue();
            if (pd_colorName == null || pd_colorName.isEmpty()) {
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名请设为文本格式)");
            }

            row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
            String diopterName = row.getCell(2).getStringCellValue();
            if (diopterName == null || diopterName.isEmpty()) {
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名请设为文本格式)");
            }
            row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
            String product_no = row.getCell(3).getStringCellValue();
            if (product_no == null || product_no.isEmpty()) {
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名请设为文本格式)");
            }
            row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
            String diopterStock = row.getCell(4).getStringCellValue();
            if (product_no == null || product_no.isEmpty()) {
                throw new MyException("导入失败(第" + (r + 1) + "行,用户名请设为文本格式)");
            }
            //完整的循环一次 就组成了一个对象
            int product_id=productService.selectId(product_name);
            int pd_colorId=product_colorService.selectId(product_id,pd_colorName);
            diopter.setProduct_id(product_id);
            diopter.setPd_colorId(pd_colorId);
            diopter.setDiopterName(diopterName);
            diopter.setProduct_no(product_no);
            diopter.setDiopterStock(Integer.parseInt(diopterStock));
            diopters.add(diopter);
        }
        diopterMapper.addDiopterList(diopters);
        return notNull;
    }

}
