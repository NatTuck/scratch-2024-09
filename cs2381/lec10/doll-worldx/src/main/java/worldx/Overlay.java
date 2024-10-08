/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *                                                                       *
 *   JavaWorld Library, Copyright 2011 Bryan Chadwick                    *
 *                                                                       *
 *   FILE: ./image/Overlay.java                                          *
 *                                                                       *
 *   This file is part of JavaWorld.                                     *
 *                                                                       *
 *   JavaWorld is free software: you can redistribute it and/or          *
 *   modify it under the terms of the GNU General Public License         *
 *   as published by the Free Software Foundation, either version        *
 *   3 of the License, or (at your option) any later version.            *
 *                                                                       *
 *   JavaWorld is distributed in the hope that it will be useful,        *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of      *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the       *
 *   GNU General Public License for more details.                        *
 *                                                                       *
 *   You should have received a copy of the GNU General Public License   *
 *   along with JavaWorld.  If not, see <http://www.gnu.org/licenses/>.  *
 *                                                                       *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

package worldx;

import java.awt.*;

/**
 * <style type='text/css'><!--
 *    .com{ font-style: italic; color: #880000; }
 *    .keyw{ font-weight: bold; color: #000088; }
 *    .num{ color: #00AA00; }
 *    .str{ color: #CC00AB; }
 *    .prim{ color: #0000FF; }
 *    img.example{ padding-left: 50px; padding-bottom: 30px; }
 *  --></style>
 * 
 * Represents the Overlaying of two or more images.
 *
 * <pre>
 *    <span class='keyw'>new</span> Overlay(<span class='keyw'>new</span> Rectangle(<span class='num'>30</span>, <span class='num'>60</span>, <span class='str'>"solid"</span>, <span class='str'>"orange"</span>),
 *                <span class='keyw'>new</span> Ellipse(<span class='num'>60</span>, <span class='num'>30</span>, <span class='str'>"solid"</span>, <span class='str'>"purple"</span>))</pre>
 * <img class="example" src="test/images/overlay-1.png" />
 * <br />
 *
 *             
 * <pre>
 *    <span class='keyw'>new</span> Overlay(<span class='keyw'>new</span> Ellipse(<span class='num'>10</span>, <span class='num'>10</span>, <span class='str'>"solid"</span>, <span class='str'>"red"</span>),
 *                <span class='keyw'>new</span> Ellipse(<span class='num'>20</span>, <span class='num'>20</span>, <span class='str'>"solid"</span>, <span class='str'>"black"</span>),
 *                <span class='keyw'>new</span> Ellipse(<span class='num'>30</span>, <span class='num'>30</span>, <span class='str'>"solid"</span>, <span class='str'>"red"</span>),
 *                <span class='keyw'>new</span> Ellipse(<span class='num'>40</span>, <span class='num'>40</span>, <span class='str'>"solid"</span>, <span class='str'>"black"</span>),
 *                <span class='keyw'>new</span> Ellipse(<span class='num'>50</span>, <span class='num'>50</span>, <span class='str'>"solid"</span>, <span class='str'>"red"</span>),
 *                <span class='keyw'>new</span> Ellipse(<span class='num'>60</span>, <span class='num'>60</span>, <span class='str'>"solid"</span>, <span class='str'>"black"</span>))</pre>
 * <img class="example" src="test/images/overlay-2.png" />
 * <br />
 *
 *        
 * <pre>
 *    <span class='keyw'>new</span> Overlay(<span class='keyw'>new</span> RegularPolygon(<span class='num'>20</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#3232FF"</span>),
 *                <span class='keyw'>new</span> RegularPolygon(<span class='num'>26</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#6464FF"</span>),
 *                <span class='keyw'>new</span> RegularPolygon(<span class='num'>32</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#9696FF"</span>),
 *                <span class='keyw'>new</span> RegularPolygon(<span class='num'>38</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#C8C8FF"</span>),
 *                <span class='keyw'>new</span> RegularPolygon(<span class='num'>44</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#FAFAFF"</span>))</pre>
 * <img class="example" src="test/images/overlay-3.png" />
 * <br />
 * <br />
 *
 * Image overlays are also available as a method on <code>Image</code>s.
 *
 * <pre>
 *    <span class='keyw'>new</span> Ellipse(<span class='num'>60</span>, <span class='num'>30</span>, <span class='str'>"solid"</span>, <span class='str'>"purple"</span>)
 *        .overlay(<span class='keyw'>new</span> Rectangle(<span class='num'>30</span>, <span class='num'>60</span>, <span class='str'>"solid"</span>, <span class='str'>"orange"</span>))</pre>
 * <img class="example" src="test/images/overlay-1.2.png" />
 * <br />
 *
 *    
 * <pre>
 *    <span class='keyw'>new</span> Ellipse(<span class='num'>60</span>, <span class='num'>60</span>, <span class='str'>"solid"</span>, <span class='str'>"black"</span>)
 *        .overlay(<span class='keyw'>new</span> Ellipse(<span class='num'>10</span>, <span class='num'>10</span>, <span class='str'>"solid"</span>, <span class='str'>"red"</span>),
 *                 <span class='keyw'>new</span> Ellipse(<span class='num'>20</span>, <span class='num'>20</span>, <span class='str'>"solid"</span>, <span class='str'>"black"</span>),
 *                 <span class='keyw'>new</span> Ellipse(<span class='num'>30</span>, <span class='num'>30</span>, <span class='str'>"solid"</span>, <span class='str'>"red"</span>),
 *                 <span class='keyw'>new</span> Ellipse(<span class='num'>40</span>, <span class='num'>40</span>, <span class='str'>"solid"</span>, <span class='str'>"black"</span>),
 *                 <span class='keyw'>new</span> Ellipse(<span class='num'>50</span>, <span class='num'>50</span>, <span class='str'>"solid"</span>, <span class='str'>"red"</span>))</pre>
 * <img class="example" src="test/images/overlay-2.2.png" />
 * <br />
 *
 *    
 * <pre>
 *    <span class='keyw'>new</span> RegularPolygon(<span class='num'>44</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#FAFAFF"</span>)
 *        .overlay(<span class='keyw'>new</span> RegularPolygon(<span class='num'>20</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#3232FF"</span>),
 *                 <span class='keyw'>new</span> RegularPolygon(<span class='num'>26</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#6464FF"</span>),
 *                 <span class='keyw'>new</span> RegularPolygon(<span class='num'>32</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#9696FF"</span>),
 *                 <span class='keyw'>new</span> RegularPolygon(<span class='num'>38</span>, <span class='num'>5</span>, <span class='str'>"solid"</span>, <span class='str'>"#C8C8FF"</span>))</pre>
 * <img class="example" src="test/images/overlay-3.2.png" />
 * <br />
 * 
 */
public class Overlay extends Image {
    protected Image top;
    protected Image bot;
    protected double width;
    protected double height;
    
    /** Construct an Overlay from the two or more Images */
    public Overlay(Image top, Image next, Image ... imgs) {
        this(top, imgs.length==0?next:make(next, imgs, 0));
    }
    /** Construct an Overlay from the two Images */
    protected Overlay(Image top, Image bot) {
        this(top, bot,
                (Math.max(top.leftOfPin(),bot.leftOfPin())+
                 Math.max(top.rightOfPin(),bot.rightOfPin())),
                (Math.max(top.upOfPin(),bot.upOfPin())+
                 Math.max(top.downOfPin(),bot.downOfPin())));
    }
    /** Construct an Overlay from the two Images with the given width and height */
    protected Overlay(Image top, Image bot, double width, double height) {
        super(width/2, height/2);
        this.top = top;
        this.bot = bot;
        this.width = width;
        this.height = height;
    }
    /** Make a layered Image with top t and bottoms of imgs[i..] */
    private static Image make(Image t, Image[] imgs, int i) {
        if(i == imgs.length) {
            return t;
        }
        return new Overlay(t, make(imgs[i], imgs, i+1));    
    }
    
    /** Draw this Overlay image into a Graphics */
    public void paint(Graphics g, int xx, int yy) {
        this.bot.paint(g, xx, yy);
        this.top.paint(g, xx, yy);
    }
    /** Return the width of this Image */
    public int width() { 
        return (int)this.width; 
    }
    /** Return the height of this Image */
    public int height() { 
        return (int)this.height; 
    }
}
