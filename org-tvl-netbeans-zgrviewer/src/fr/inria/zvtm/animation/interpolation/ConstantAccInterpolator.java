/*
 * AUTHOR : Romain Primet (romain.primet@inria.fr)
 *
 * (c) COPYRIGHT INRIA (Institut National de Recherche en Informatique et en
 * Automatique), 2009-2010. Licensed under the GNU LGPL. For full terms see the
 * file COPYING.
 *
 * $Id: ConstantAccInterpolator.java 4270 2011-02-24 17:50:40Z epietrig $
 */
package fr.inria.zvtm.animation.interpolation;

import net.jcip.annotations.Immutable;
import org.jdesktop.animation.timing.interpolation.Interpolator;
import org.jdesktop.animation.timing.interpolation.SplineInterpolator;

/**
 * A class that implements constant acceleration ('slow in, fast out')
 * interpolation.
 *
 * @author Romain Primet
 */
@Immutable
public class ConstantAccInterpolator {

    //Disallow instanciation
    private ConstantAccInterpolator() {
    }

    /**
     * Returns Interpolator instance
     *
     * @return an Interpolator that implements constant acceleration
     * interpolation
     */
    public static Interpolator getInstance() {
        //interpolator has no state, hence we share it among all animations
        //XXX I'm assuming that the underlying SplineInterpolator is thread-safe.
        //This is almost self-evident, but may be worth checking

        return INSTANCE;
    }

    private static final Interpolator INSTANCE = new SplineInterpolator(.5f, 0f, 1f, .5f);
}
