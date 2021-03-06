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

import org.eclipse.aether.transfer.AbstractTransferListener;
import org.eclipse.aether.transfer.TransferEvent;

import com.jcabi.aspects.Immutable;
import com.jcabi.aspects.Loggable;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Logger of transfer events.
 *
 * @author Yegor Bugayenko (yegor@tpc2.com)
 * @version $Id: cf7b4fc85829d72acd15bcfabfd3729002f700c5 $
 * @since 0.1.6
 */
@Immutable
@ToString
@EqualsAndHashCode(callSuper = false)
final class LogTransferListener extends AbstractTransferListener {

    /**
     * {@inheritDoc}
     */
    @Override
    @Loggable(Loggable.WARN)
    public void transferFailed(final TransferEvent event) {
        // nothing to do
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Loggable(Loggable.WARN)
    public void transferCorrupted(final TransferEvent event) {
        // nothing to do
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Loggable(Loggable.INFO)
    public void transferSucceeded(final TransferEvent event) {
        // nothing to do
    }

}
