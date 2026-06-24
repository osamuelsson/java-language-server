package org.javacs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.nio.file.Paths;
import org.junit.Test;

public class InferBazelParamsTest {

    @Test
    public void classPathFromParamsFiles() {
        var infer = new InferConfig(Paths.get("src/test/examples/bazel-params-project"));
        var classPath = infer.classPath();
        assertThat(classPath, hasItem(hasToString(containsString("guava-18.0"))));
    }

    @Test
    public void classPathFromParamsFilesInSubdir() {
        var infer = new InferConfig(Paths.get("src/test/examples/bazel-params-project/hello"));
        var classPath = infer.classPath();
        assertThat(classPath, hasItem(hasToString(containsString("guava-18.0"))));
    }

    @Test
    public void multipleClasspathEntriesParsed() {
        var infer = new InferConfig(Paths.get("src/test/examples/bazel-params-project"));
        var classPath = infer.classPath();
        assertThat(classPath, hasSize(2));
        assertThat(classPath, hasItem(hasToString(containsString("guava-18.0"))));
        assertThat(classPath, hasItem(hasToString(containsString("error_prone_annotations-2.3.4"))));
    }
}
