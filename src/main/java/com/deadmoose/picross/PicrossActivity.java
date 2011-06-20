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

import android.app.Activity;
import android.os.Bundle;

public class PicrossActivity extends Activity
{
    @Override
    public void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}