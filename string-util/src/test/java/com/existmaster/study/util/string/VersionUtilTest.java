package com.existmaster.study.util.string;

import com.existmaster.study.util.string.version.VersionModel;
import com.existmaster.study.util.string.version.VersionUtil;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by existmaster on 2015. 12. 20..
 */
public class VersionUtilTest {

    @Test
    public void versionCompareTest(){

        assertTrue(VersionUtil.needUpdate("1.0.0", "1.0.1"));
        assertTrue(VersionUtil.needUpdate("1.0.0.1", "1.1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void versionParsing_OverSplitLegth(){
        VersionUtil.versionParsing("1.2.3.1.1");
    }

    @Test(expected = NumberFormatException.class)
    public void versionParsing_IllegalArg(){
        VersionUtil.versionParsing("abc");
    }
    @Test
    public void versionParsingTest(){

        VersionModel expectResult = new VersionModel(1,0,0);
        VersionModel result = VersionUtil.versionParsing("1.0.0");

        assertThat(result.getMajor(), is(expectResult.getMajor()));
        assertThat(result.getMinor(), is(expectResult.getMinor()));
        assertThat(result.getBuild(), is(expectResult.getBuild()));
        assertThat(result.getRevision(), is(0));

    }
}
