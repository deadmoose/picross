// Picross - http://github.com/deadmoose/picross
//
// Copyright (C) 2011 David Hoover
//
// Picross is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// Picross is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with Picross. If not, see <http://www.gnu.org/licenses/>.

package com.deadmoose.picross;

import java.util.Arrays;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * The state of a puzzle being worked on by a human.
 */
public class PuzzleState implements Parcelable
{
    /** Allow PuzzleStates to be made from Parcels */
    public static final Parcelable.Creator<PuzzleState> CREATOR =
        new Parcelable.Creator<PuzzleState>() {
            public PuzzleState createFromParcel(Parcel in) {
                return new PuzzleState(in);
            }

            public PuzzleState[] newArray (int size) {
                return new PuzzleState[size];
            }
        };

    /** The puzzle we're working on. Maybe keep this as an ID instead of the whole thing? */
    public final Puzzle puzzle;

    /** The state of our guesses. */
    public final PixelState[] pixels;

    /** Whether or not we show incorrect guesses. */
    public boolean showMistakes;

    /**
     * Describes the state of a pixel to the best of the player's knowledge.
     */
    public static enum PixelState
    {
        UNKNOWN,   // Starting state for all pixels
        ON,        // We've confirmed this pixel is on
        OFF,       // We've confirmed this pixel is off
        GUESS_ON,  // They're guessing this pixel is on
        GUESS_OFF, // They're guessing this pixel is off
        ERROR_ON,  // They guessed incorrectly. This pixel is really on.
        ERROR_OFF, // They guessed incorrectly. This pixel is really off.
    };

    public PuzzleState (Puzzle puzzle, boolean showMistakes)
    {
        this.puzzle = puzzle;
        this.showMistakes = showMistakes;

        pixels = new PixelState[puzzle.pixels.length];
        Arrays.fill(pixels, PixelState.UNKNOWN);
    }

    /**
     * Initialize a new PuzzleState from a Parcel.
     */
    public PuzzleState (Parcel in)
    {
        this.puzzle = in.readParcelable(null);
        this.pixels = (PixelState[])in.readArray(PixelState.class.getClassLoader());

        // Ugh. there're no read/write boolean methods, so have to wrap them in an array.
        boolean[] flags = in.createBooleanArray();
        this.showMistakes = flags[0];

    }

    @Override
    public void writeToParcel (Parcel dest, int flags)
    {
        dest.writeParcelable(this.puzzle, flags);
        dest.writeArray(this.pixels);

        // Ugh. there're no read/write boolean methods, so have to wrap them in an array.
        dest.writeBooleanArray(new boolean[] { this.showMistakes });
    }

    @Override
    public int describeContents ()
    {
        // Nothing exciting
        return 0;
    }
}
