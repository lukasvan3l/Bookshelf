package models;

import java.util.List;

import play.modules.siena.EnhancedModel;

import siena.Generator;
import siena.Id;

/**
 * Book downloaded in JSON from google books
 */
public class GoogleBook
{
    public String id;
    public GoogleBookInfo volumeInfo;

    public Book getBook() {
    	return volumeInfo.getBook();
	}
}