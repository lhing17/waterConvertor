package cn.gsein.water.converter.factory;

import cn.gsein.water.FileType;
import cn.gsein.water.converter.Converter;
import cn.gsein.water.converter.image.ImageToImageConverter;
import cn.gsein.water.converter.image.SvgToImageConverter;
import cn.gsein.water.converter.image.TextToImageConverter;
import cn.gsein.water.exception.UnsupportedTypeConvertException;

/**
 * 图片文件转化器工厂
 *
 * @author G. Seinfeld
 * @since 2020-05-13
 */
public class ImageConverterFactory implements ConverterFactory {

    @Override
    public Converter create(FileType from) {
        switch (from) {
            case TXT:
                return new TextToImageConverter();
            case JPG:
            case PNG:
            case BMP:
            case GIF:
            case TIFF:
                return new ImageToImageConverter();
            case SVG:
                return new SvgToImageConverter();
            default:
                throw new UnsupportedTypeConvertException("暂时不支持从" + from.getName() + "向图片的转换！");
        }


    }
}
