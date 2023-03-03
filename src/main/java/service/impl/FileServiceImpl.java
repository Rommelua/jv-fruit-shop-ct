package service.impl;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import service.FileService;

public class FileServiceImpl implements FileService {
    private static final int BUFFER_CAPACITY = 512;
    private static final String READ_ACCESS_TYPE = "r";
    private static final String READ_WRITE_ACCESS_TYPE = "rw";

    @Override
    public void writeToFile(String filePath, String report) {
        Set<StandardOpenOption> options = new HashSet<>();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.WRITE);
        try {
            FileChannel fileChannel = FileChannel.open(Paths.get(filePath),options);
            fileChannel.write(ByteBuffer.wrap(report.getBytes()));
        } catch (IOException e) {
            System.out.println("Error with access to the output file" + e.getMessage());
        }
    }

    @Override
    public List<String> readFromFile(String filePath) {
        String inputLine = "";

        try {
            RandomAccessFile file = new RandomAccessFile(filePath, READ_ACCESS_TYPE);
            FileChannel fileChannel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(BUFFER_CAPACITY);
            while (fileChannel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    inputLine = inputLine + (char)byteBuffer.get();
                }
            }
            file.close();
        } catch (IOException exception) {
            System.out.println("File with this path doesn`t found" + exception.getMessage());
        }
        String[] strArr = inputLine.split(System.lineSeparator());
        List<String> inputListStrings = new ArrayList<>(Arrays.asList(strArr));
        return inputListStrings;
    }
}

