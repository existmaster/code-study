package com.existmaster.study.util.string.version;

/**
 * Created by existmaster on 2015. 12. 20..
 */
public class VersionModel {

    int major;
    int minor;
    int build;
    int revision;

    public VersionModel() {
    }

    public VersionModel(int major, int minor) {
        this.major = major;
        this.minor = minor;
    }

    public VersionModel(int major, int minor, int build) {
        this.major = major;
        this.minor = minor;
        this.build = build;
    }

    public VersionModel(int major, int minor, int build, int revision) {
        this.major = major;
        this.minor = minor;
        this.build = build;
        this.revision = revision;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getBuild() {
        return build;
    }

    public void setBuild(int build) {
        this.build = build;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }
}
