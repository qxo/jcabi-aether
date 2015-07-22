/**
 * Copyright (c) 2012-2015, jcabi.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met: 1) Redistributions of source code must retain the above
 * copyright notice, this list of conditions and the following
 * disclaimer. 2) Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided
 * with the distribution. 3) Neither the name of the jcabi.com nor
 * the names of its contributors may be used to endorse or promote
 * products derived from this software without specific prior written
 * permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.jcabi.aether;

import org.apache.maven.repository.internal.DefaultArtifactDescriptorReader;
import org.apache.maven.repository.internal.DefaultVersionRangeResolver;
import org.apache.maven.repository.internal.DefaultVersionResolver;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.connector.async.AsyncRepositoryConnectorFactory;
import org.eclipse.aether.connector.file.FileRepositoryConnectorFactory;
import org.eclipse.aether.connector.wagon.WagonConfigurator;
import org.eclipse.aether.connector.wagon.WagonProvider;
import org.eclipse.aether.connector.wagon.WagonRepositoryConnectorFactory;
import org.eclipse.aether.impl.ArtifactDescriptorReader;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.impl.VersionRangeResolver;
import org.eclipse.aether.impl.VersionResolver;
import org.eclipse.aether.internal.connector.wagon.PlexusWagonConfigurator;
import org.eclipse.aether.internal.impl.DefaultRepositorySystem;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;

import com.jcabi.aspects.Immutable;
import com.jcabi.aspects.Loggable;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Builder of {@link RepositorySystem} class.
 *
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id: 907f57933e3e4aa840db4516e27683e96e59b825 $
 * @since 0.1.6
 */
@Immutable
@ToString
@EqualsAndHashCode
final class RepositorySystemBuilder implements RepositorySystemFactory {

    /**
     * Build it.
     * @return The repo system.
     */
    @Loggable(Loggable.DEBUG)
    public RepositorySystem build() {
        final DefaultServiceLocator locator = new DefaultServiceLocator();
        locator.addService(
            RepositoryConnectorFactory.class,
            FileRepositoryConnectorFactory.class
        );
        locator.addService(
            RepositoryConnectorFactory.class,
            AsyncRepositoryConnectorFactory.class
        );
        locator.addService(
            WagonProvider.class,
            AmazonWagonProvider.class
        );
        locator.addService(
            WagonConfigurator.class,
            PlexusWagonConfigurator.class
        );
        locator.addService(
            RepositoryConnectorFactory.class,
            WagonRepositoryConnectorFactory.class
        );
        locator.addService(
            RepositorySystem.class,
            DefaultRepositorySystem.class
        );
        locator.addService(
            VersionResolver.class,
            DefaultVersionResolver.class
        );
        locator.addService(
            VersionRangeResolver.class,
            DefaultVersionRangeResolver.class
        );
        locator.addService(
            ArtifactDescriptorReader.class,
            DefaultArtifactDescriptorReader.class
        );
        final RepositorySystem system =
            locator.getService(RepositorySystem.class);
        if (system == null) {
            throw new IllegalStateException("failed to get service");
        }
        return system;
    }

}
