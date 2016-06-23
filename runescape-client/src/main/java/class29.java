import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public final class class29 extends class85 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1720566053
   )
   int field692;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2042096571
   )
   int field693;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1931160275
   )
   int field694;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2025166997
   )
   int field695;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 907459123
   )
   int field696;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1189394451
   )
   int field697;
   @ObfuscatedName("n")
   class42 field698;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 414650791
   )
   int field699 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1500853711
   )
   int field700 = 0;
   @ObfuscatedName("s")
   boolean field701 = false;
   @ObfuscatedName("bk")
   static class168 field702;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "113"
   )
   final void method700(int var1) {
      if(!this.field701) {
         this.field700 += var1;

         while(this.field700 > this.field698.field1004[this.field699]) {
            this.field700 -= this.field698.field1004[this.field699];
            ++this.field699;
            if(this.field699 >= this.field698.field999.length) {
               this.field701 = true;
               break;
            }
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(S)Lclass105;",
      garbageValue = "1006"
   )
   protected final class105 vmethod1968() {
      class43 var1 = class1.method12(this.field696);
      class105 var2;
      if(!this.field701) {
         var2 = var1.method952(this.field699);
      } else {
         var2 = var1.method952(-1);
      }

      return null == var2?null:var2;
   }

   class29(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.field696 = var1;
      this.field694 = var2;
      this.field695 = var3;
      this.field692 = var4;
      this.field697 = var5;
      this.field693 = var7 + var6;
      int var8 = class1.method12(this.field696).field1020;
      if(var8 != -1) {
         this.field701 = false;
         this.field698 = class34.method768(var8);
      } else {
         this.field701 = true;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1945398017"
   )
   static void method706() {
      if(class23.method623()) {
         class31.field722 = true;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZZI)V",
      garbageValue = "-1806281173"
   )
   public static void method707(String var0, boolean var1, boolean var2) {
      if(var1) {
         if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if(class138.field2133.startsWith("win")) {
            client.method309(var0, 0, "openjs");
         } else if(class138.field2133.startsWith("mac")) {
            client.method309(var0, 1, "openjs");
         } else {
            client.method309(var0, 2, "openjs");
         }
      } else {
         client.method309(var0, 3, "openjs");
      }

   }
}
