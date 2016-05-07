import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
public class class0 extends class208 {
   @ObfuscatedName("hp")
   @ObfuscatedGetter(
      intValue = -71399369
   )
   static int field0;
   @ObfuscatedName("j")
   boolean field1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1924903443
   )
   int field2;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 496157325
   )
   int field3;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1132059285
   )
   int field4;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -741415629
   )
   int field5;
   @ObfuscatedName("o")
   class173 field6;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1041044397
   )
   int field7;
   @ObfuscatedName("p")
   class173 field8;
   @ObfuscatedName("c")
   String field9;
   @ObfuscatedName("s")
   Object[] field12;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1987204281
   )
   int field14;

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-90"
   )
   static void method0() {
      int var0 = class144.field2210;
      int var1 = class144.field2211;
      int var2 = class32.field770 - class15.field214 - var0;
      int var3 = class131.field2079 - class15.field215 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = client.field276.method2996();
            int var5 = 0;
            int var6 = 0;
            if(var4 == class85.field1464) {
               Insets var7 = class85.field1464.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class131.field2079);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class32.field770, var1);
            }

            if(var2 > 0) {
               var9.fillRect(var5 + class32.field770 - var2, var6, var2, class131.field2079);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class131.field2079 + var6 - var3, class32.field770, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }
}
