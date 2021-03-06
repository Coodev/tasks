/*
 * Copyright (C) 2013 Marten Gajda <marten@dmfs.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.dmfs.tasks.groupings.cursorloaders;

import org.dmfs.tasks.utils.SearchHistoryHelper;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.Loader;


/**
 * An {@link AbstractCursorLoaderFactory} that returns {@link CursorLoaderFactory} that know how to load cursors with the search history.
 * 
 * @author Tobias Reinsch <tobias@dmfs.org>
 */
public class SearchHistoryCursorLoaderFactory extends AbstractCursorLoaderFactory
{

	private final SearchHistoryHelper mSeachHistory;


	public SearchHistoryCursorLoaderFactory(SearchHistoryHelper history)
	{
		mSeachHistory = history;
	}


	@Override
	public Loader<Cursor> getLoader(Context context)
	{
		return new CustomCursorLoader(context, new SearchHistoryCursorFactory(context, null, mSeachHistory));
	}
}
