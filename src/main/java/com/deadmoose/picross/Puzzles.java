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
// along with Picross. If notrue,   see <http://www.gnu.org/licenses/>.

package com.deadmoose.picross;

/**
 * Contains some simple puzzles for testing.
 */
public class Puzzles
{
    /**
     * 5x5, all pixels on.
     */
    public static final Puzzle ALL_ON = new Puzzle(
        new boolean[] {
            true,  true,  true,  true,  true,
            true,  true,  true,  true,  true,
            true,  true,  true,  true,  true,
            true,  true,  true,  true,  true,
            true,  true,  true,  true,  true,
        }, 5, 5);

    /**
     * 5x5, empty box.
     */
    public static final Puzzle BORDER = new Puzzle(
        new boolean[] {
            true,  true,  true,  true,  true,
            true,  false, false, false, true,
            true,  false, false, false, true,
            true,  false, false, false, true,
            true,  true,  true,  true,  true,
        }, 5, 5);

    /**
     * 10x10, smiley face.
     */
    public static final Puzzle SMILEY_FACE = new Puzzle(
        new boolean[] {
            false, false, false, true,  true,  true,  true,  false, false, false,
            false, true,  true,  true,  false, false, true,  true,  true,  false,
            false, true,  false, false, false, false, false, false, true,  false,
            true,  true,  false, true,  false, false, true,  false, true,  true,
            true,  false, false, false, false, false, false, false, false, true,
            true,  false, false, true,  false, false, true,  false, false, true,
            true,  true,  false, false, true,  true,  false, false, true,  true,
            false, true,  false, false, false, false, false, false, true,  false,
            false, true,  true,  true,  false, false, true,  true,  true,  false,
            false, false, false, true,  true,  true,  true,  false, false, false,
        }, 10, 10);
}
