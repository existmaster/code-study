package com.existmaster.study.util.string.version;

/**
 * Created by existmaster on 2015. 12. 20..
 */
public class VersionUtil {
    public static final String SPLIT_CODE = "\\.";
    public static final int SPLIT_LENGTH_FOR_ONLY_MAJOR_VERSION = 1;
    public static final int SPLIT_LENGTH_FOR_MAJOR_AND_MINOR = 2;
    public static final int SPLIT_LENGTH_FOR_MAJOR_MINOR_AND_BUILD = 3;
    public static final int SPLIT_LENGTH_FOR_MAJOR_MINOR_BUILD_AND_REVISION = 4;
    public static final String EXCEPTION_MESSAGE = "지원하는 형식의 데이터가 아닙니다";

    public static boolean needUpdate(String original, String target) {

        VersionModel original_version = versionParsing(original);
        VersionModel target_version = versionParsing(target);

        if(target_version.getMajor() > original_version.getMajor() ||
                target_version.getMinor() > original_version.getMinor() ||
                target_version.getBuild() > original_version.getBuild() ||
                target_version.getRevision() > original_version.getRevision()) return true;

        return false;
    }

    public static VersionModel versionParsing(String string) {

        String[] parseString = string.split(SPLIT_CODE);

        VersionModel result = new VersionModel();

        switch(parseString.length){
            case SPLIT_LENGTH_FOR_MAJOR_MINOR_BUILD_AND_REVISION:
                result.setRevision(Integer.valueOf(parseString[3]));
            case SPLIT_LENGTH_FOR_MAJOR_MINOR_AND_BUILD:
                result.setBuild(Integer.valueOf(parseString[2]));
            case SPLIT_LENGTH_FOR_MAJOR_AND_MINOR:
                result.setMinor(Integer.valueOf(parseString[1]));
            case SPLIT_LENGTH_FOR_ONLY_MAJOR_VERSION:
                result.setMajor(Integer.valueOf(parseString[0]));
                break;
            default:
                throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }

        return result;
    }
}
