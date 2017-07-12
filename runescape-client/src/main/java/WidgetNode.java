import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -55516781
   )
   @Export("id")
   int id;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 859282669
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("a")
   boolean field845;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LModel;IIII)V",
      garbageValue = "-1353774979"
   )
   public static final void method1124(Model var0, int var1, int var2, int var3) {
      if(method1125(var0, var1, var2, var3)) {
         class45.method653(var0, var1, var2, var3, -65281);
      } else if(class7.field233 == class11.field263) {
         class45.method653(var0, var1, var2, var3, -16776961);
      }

   }

   WidgetNode() {
      this.field845 = false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LModel;IIII)Z",
      garbageValue = "-282869302"
   )
   public static final boolean method1125(Model var0, int var1, int var2, int var3) {
      boolean var4 = class134.field2003;
      if(!var4) {
         return false;
      } else {
         int var5;
         int var6;
         int var7;
         int var8;
         int var9;
         int var10;
         int var11;
         int var12;
         int var13;
         if(!class134.field2004) {
            var5 = Region.pitchSin;
            var6 = Region.pitchCos;
            var7 = Region.yawSin;
            var8 = Region.yawCos;
            byte var14 = 50;
            short var15 = 3500;
            var9 = (class134.field2014 - Graphics3D.centerX) * var14 / Graphics3D.field2031;
            var10 = (class134.field2008 - Graphics3D.centerY) * var14 / Graphics3D.field2031;
            var11 = (class134.field2014 - Graphics3D.centerX) * var15 / Graphics3D.field2031;
            int var16 = (class134.field2008 - Graphics3D.centerY) * var15 / Graphics3D.field2031;
            int var17 = Graphics3D.method2642(var10, var14, var6, var5);
            var12 = Graphics3D.method2586(var10, var14, var6, var5);
            var10 = var17;
            var17 = Graphics3D.method2642(var16, var15, var6, var5);
            var13 = Graphics3D.method2586(var16, var15, var6, var5);
            var16 = var17;
            var17 = Graphics3D.method2602(var9, var12, var8, var7);
            var12 = Graphics3D.method2608(var9, var12, var8, var7);
            var9 = var17;
            var17 = Graphics3D.method2602(var11, var13, var8, var7);
            var13 = Graphics3D.method2608(var11, var13, var8, var7);
            class134.field2001 = (var17 + var9) / 2;
            class134.field2006 = (var10 + var16) / 2;
            class134.field2007 = (var13 + var12) / 2;
            class27.field397 = (var17 - var9) / 2;
            class134.field2002 = (var16 - var10) / 2;
            class207.field2582 = (var13 - var12) / 2;
            class134.field2009 = Math.abs(class27.field397);
            class244.field3321 = Math.abs(class134.field2002);
            ChatLineBuffer.field1576 = Math.abs(class207.field2582);
         }

         var5 = var0.field1969 + var1;
         var6 = var2 + var0.field1989;
         var7 = var3 + var0.field1932;
         var8 = var0.field1966;
         var12 = var0.field1967;
         var13 = var0.field1968;
         var9 = class134.field2001 - var5;
         var10 = class134.field2006 - var6;
         var11 = class134.field2007 - var7;
         return Math.abs(var9) > var8 + class134.field2009?false:(Math.abs(var10) > var12 + class244.field3321?false:(Math.abs(var11) > var13 + ChatLineBuffer.field1576?false:(Math.abs(var11 * class134.field2002 - var10 * class207.field2582) > var12 * ChatLineBuffer.field1576 + var13 * class244.field3321?false:(Math.abs(var9 * class207.field2582 - var11 * class27.field397) > ChatLineBuffer.field1576 * var8 + var13 * class134.field2009?false:Math.abs(var10 * class27.field397 - var9 * class134.field2002) <= var12 * class134.field2009 + var8 * class244.field3321))));
      }
   }
}
