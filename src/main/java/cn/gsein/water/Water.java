package cn.gsein.water;

import cn.gsein.water.converter.Converter;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 统一对外接口
 *
 * @author G. Seinfeld
 * @since 2020-05-13
 */
@Data
@Slf4j
public class Water {
    private FileType from;
    private FileType to;
    private InputStream input;
    private OutputStream output;
    private Converter converter;

    public Water(FileType from, FileType to, InputStream input, OutputStream output, Converter converter) {
        this.from = from;
        this.to = to;
        this.input = input;
        this.output = output;
        this.converter = converter;
    }

    public void convert() {
        try {
            converter.convert(from, to, input, output);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
            } catch (IOException ignored) {
            }
        }
    }
}