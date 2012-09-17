package models;

import java.util.List;

import play.modules.siena.EnhancedModel;

import siena.Generator;
import siena.Id;

/**
 * Owner of a bookshelf
 */
public class Book extends EnhancedModel
{
    @Id(Generator.NONE)
    public String id;

    public String isbn;

    public String name;
}
