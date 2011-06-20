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

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents an actual picross puzzle.
 *
 * Right now, it's just the bitmap. Eventually, this will ideally include some more information
 * about it such as a colorful version to display when it's finished.
 *
 * It'd also be good to eventually let this support sub-puzzles (e.g. a 40x40 puzzle that's really
 * just a 2x2 grid of 20x20 puzzles), but for now, we'll ignore that.
 */
public class Puzzle implements Parcelable
{
    /** Allow PuzzleStates to be made from Parcels */
    public static final Parcelable.Creator<Puzzle> CREATOR =
        new Parcelable.Creator<Puzzle>() {
            public Puzzle createFromParcel(Parcel in) {
                return new Puzzle(in);
            }

            public Puzzle[] newArray (int size) {
                return new Puzzle[size];
            }
        };

    /** The pixels that are toggled on for this puzzle. */
    public final boolean[] pixels;

    /** The width of this puzzle. */
    public final int width;

    /** The height of this puzzle. */
    public final int height;

    public Puzzle (boolean[] pixels, int width, int height)
    {
        // Assume it's well-formed and consistent dimensions. Should obvious validate this sort of
        // thing once we can slurp in new puzzles from the internets.
        this.pixels = pixels;
        this.width = width;
        this.height = height;
    }

    public Puzzle (Parcel in)
    {
        this(in.createBooleanArray(), in.readInt(), in.readInt());
    }

    @Override
    public void writeToParcel (Parcel dest, int flags)
    {
        dest.writeBooleanArray(pixels);
        dest.writeInt(width);
        dest.writeInt(height);
    }

    @Override
    public int describeContents ()
    {
        // Nothing special
        return 0;
    }

}
