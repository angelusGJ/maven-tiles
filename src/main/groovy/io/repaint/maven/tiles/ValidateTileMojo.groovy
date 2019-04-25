package io.repaint.maven.tiles

import groovy.transform.CompileStatic
import org.apache.maven.plugin.MojoExecutionException
import org.apache.maven.plugin.MojoFailureException
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.ResolutionScope

/**
 *
 * @author: Richard Vowles - https://plus.google.com/+RichardVowles
 * @author: Mark Derricutt - https://plus.google.com/+MarkDerricutt
 */
@CompileStatic
@Mojo(name = "validate", requiresProject = true, requiresDependencyResolution = ResolutionScope.NONE, threadSafe = true)
class ValidateTileMojo extends AbstractTileMojo {

	@Override
	void execute() throws MojoExecutionException, MojoFailureException {
		if (project.modules) {
			logger.info("Ignoring reactor for tile check.")
		} else {
			new TileValidator().loadModel(logger, getTile(), buildSmells)
		}
	}
}
