import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.io.IOException;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("de")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("qm")
   @ObfuscatedGetter(
      intValue = -289194849
   )
   public static int field1756;
   @ObfuscatedName("n")
   Component field1760;

   public final void update(Graphics var1) {
      this.field1760.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field1760.paint(var1);
   }

   RSCanvas(Component var1) {
      this.field1760 = var1;
   }

   @ObfuscatedName("er")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1401863548"
   )
   static void method2171(Buffer var0) {
      if(null != Client.field326) {
         var0.method2880(Client.field326, 0, Client.field326.length);
      } else {
         byte[] var2 = new byte[24];

         try {
            class104.field1689.method1464(0L);
            class104.field1689.method1466(var2);

            int var3;
            for(var3 = 0; var3 < 24 && var2[var3] == 0; ++var3) {
               ;
            }

            if(var3 >= 24) {
               throw new IOException();
            }
         } catch (Exception var6) {
            for(int var4 = 0; var4 < 24; ++var4) {
               var2[var4] = -1;
            }
         }

         var0.method2880(var2, 0, var2.length);
      }
   }
}
