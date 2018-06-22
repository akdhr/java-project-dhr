package com.dhr.basics.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description :文件读取工具
 * Created by duanhr30063 on 2017/11/20.
 */

public class FileUtil {

    /**
     * 文件读取、默认缓冲区大小 5MB
     */
    public static final Integer DEFAULT_BUFFER_SIZE = 5 * 1024 * 1024;

    /**
     * 按字符读取
     */
    public static void readFileBycharacter(String fileName) throws IOException {
        Reader reader = null;
        try {
            reader = new InputStreamReader(new FileInputStream(fileName));
            int charread = 0;
            char[] tempchars = new char[30];
            while ((charread = reader.read(tempchars)) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。
                if ((charread == tempchars.length) && (tempchars[tempchars.length - 1] != '\r')) {
                    System.out.print(tempchars);
                } else {
                    for (int i = 0; i < charread; i++) {
                        if (tempchars[i] == '\r') {
                            continue;
                        } else {
                            System.out.print(tempchars[i]);
                        }
                    }
                }
            }

        } catch (FileNotFoundException e) {

        } finally {
            reader.close();
        }

    }

    /**
     * 按字节读取
     */
    public static void readFileByByte(String fileName) {
        InputStream fis = null;
        try {
            fis = new FileInputStream(fileName);
            int len = 0;
            byte[] buf = new byte[4096];//定义一个缓冲区,进行读取(常用)
            while ((len = fis.read(buf)) != -1) {
                System.out.println(new String(buf));
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            close(fis);
        }
    }

    /**
     * 按行读取（字符流）, 常用于读面向行的格式化文件
     *
     * @param fileName
     */
    public static void readFileByLines(String fileName) {
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                if ("".equals(tempString))//去除空行
                    continue;
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

    /**
     * 按行读取文件(字节流)，支持大文件读取，不会一次性加载到内存中，默认缓冲区5M;
     * 性能好，不丢失内容，较常用
     * @param fileName
     * @return
     * @throws IOException
     */
    public static List<String> readFileByLine(String fileName) throws IOException {
        List<String> lines = new ArrayList<String>();
        File file = new File(fileName);
        BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "utf-8"), DEFAULT_BUFFER_SIZE);// 默认用5M的缓冲读取文本文件
        String line = "";
        while ((line = reader.readLine()) != null) {
            if ("".equals(line))
                continue;
            lines.add(line);
            System.out.println(line);
        }
        return lines;
    }

    /**
     * 关闭输入流
     * @param inputStream
     */
    public static void close(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) throws Exception {

        String fileName = "D:\\Idea_workspace\\java-project-dhr\\java-basics\\doc\\开放平台.txt";

//        FileUtil.readFileByByte(fileName);
//        FileUtil.readFileBycharacter(fileName);
//        FileUtil.readFileByLines(fileName);
        FileUtil.readFileByLine(fileName);


    }

}
