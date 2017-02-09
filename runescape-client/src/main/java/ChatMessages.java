import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import java.io.EOFException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("ChatMessages")
public class ChatMessages {
   @ObfuscatedName("r")
   boolean[] field917;
   @ObfuscatedName("o")
   boolean[] field918;
   @ObfuscatedName("w")
   int[] field919;
   @ObfuscatedName("j")
   @Export("messages")
   String[] messages;
   @ObfuscatedName("q")
   boolean field921 = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      longValue = -5974151470586986607L
   )
   long field922;
   @ObfuscatedName("bl")
   static class184 field923;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1910897636"
   )
   int method842(int var1) {
      return this.field919[var1];
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   void method843(int var1, int var2) {
      this.field919[var1] = var2;
      if(this.field918[var1]) {
         this.field921 = true;
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1778447280"
   )
   static void method844() {
      int var0 = GameEngine.field1774;
      int var1 = GameEngine.field1775;
      int var2 = class9.field84 - XItemContainer.field123 - var0;
      int var3 = class60.field1084 - class143.field1999 - var1;
      if(var0 > 0 || var2 > 0 || var1 > 0 || var3 > 0) {
         try {
            Container var4 = Client.field277.method2170();
            int var5 = 0;
            int var6 = 0;
            if(var4 == Tile.field1351) {
               Insets var7 = Tile.field1351.getInsets();
               var5 = var7.left;
               var6 = var7.top;
            }

            Graphics var9 = var4.getGraphics();
            var9.setColor(Color.black);
            if(var0 > 0) {
               var9.fillRect(var5, var6, var0, class60.field1084);
            }

            if(var1 > 0) {
               var9.fillRect(var5, var6, class9.field84, var1);
            }

            if(var2 > 0) {
               var9.fillRect(class9.field84 + var5 - var2, var6, var2, class60.field1084);
            }

            if(var3 > 0) {
               var9.fillRect(var5, class60.field1084 + var6 - var3, class9.field84, var3);
            }
         } catch (Exception var8) {
            ;
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "100"
   )
   void method845() {
      FileOnDisk var1 = this.method848(false);

      try {
         byte[] var2 = new byte[(int)var1.method1420()];

         int var4;
         for(int var3 = 0; var3 < var2.length; var3 += var4) {
            var4 = var1.method1421(var2, var3, var2.length - var3);
            if(var4 == -1) {
               throw new EOFException();
            }
         }

         Buffer var13 = new Buffer(var2);
         if(var13.payload.length - var13.offset < 1) {
            return;
         }

         int var14 = var13.readUnsignedByte();
         if(var14 < 0 || var14 > 1) {
            return;
         }

         int var15 = var13.readUnsignedShort();

         int var7;
         int var8;
         int var9;
         for(var7 = 0; var7 < var15; ++var7) {
            var8 = var13.readUnsignedShort();
            var9 = var13.method3062();
            if(this.field918[var8]) {
               this.field919[var8] = var9;
            }
         }

         var7 = var13.readUnsignedShort();

         for(var8 = 0; var8 < var7; ++var8) {
            var9 = var13.readUnsignedShort();
            String var10 = var13.method2934();
            if(this.field917[var9]) {
               this.messages[var9] = var10;
            }
         }
      } catch (Exception var24) {
         ;
      } finally {
         try {
            var1.method1419();
         } catch (Exception var23) {
            ;
         }

      }

      this.field921 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-82049867"
   )
   static void method846() {
      XItemContainer.itemContainers = new XHashTable(32);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-57"
   )
   void method847() {
      if(this.field921 && this.field922 < class22.method224() - 60000L) {
         this.method849();
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)LFileOnDisk;",
      garbageValue = "1"
   )
   FileOnDisk method848(boolean var1) {
      return Client.method610("2", MessageNode.field229.field2675, var1);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "754511126"
   )
   void method849() {
      FileOnDisk var1 = this.method848(true);

      try {
         int var2 = 3;
         int var3 = 0;

         int var4;
         for(var4 = 0; var4 < this.field919.length; ++var4) {
            if(this.field918[var4] && this.field919[var4] != -1) {
               var2 += 6;
               ++var3;
            }
         }

         var2 += 2;
         var4 = 0;

         for(int var5 = 0; var5 < this.messages.length; ++var5) {
            if(this.field917[var5] && this.messages[var5] != null) {
               var2 += 2 + class105.method1999(this.messages[var5]);
               ++var4;
            }
         }

         Buffer var9 = new Buffer(var2);
         var9.method2912(1);
         var9.method3094(var3);

         int var6;
         for(var6 = 0; var6 < this.field919.length; ++var6) {
            if(this.field918[var6] && this.field919[var6] != -1) {
               var9.method3094(var6);
               var9.method3057(this.field919[var6]);
            }
         }

         var9.method3094(var4);

         for(var6 = 0; var6 < this.messages.length; ++var6) {
            if(this.field917[var6] && null != this.messages[var6]) {
               var9.method3094(var6);
               var9.method3097(this.messages[var6]);
            }
         }

         var1.method1418(var9.payload, 0, var9.offset);
      } catch (Exception var17) {
         ;
      } finally {
         try {
            var1.method1419();
         } catch (Exception var16) {
            ;
         }

      }

      this.field921 = false;
      this.field922 = class22.method224();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lclass166;II)Z",
      garbageValue = "1301385400"
   )
   static boolean method850(class166 var0, int var1) {
      int var2 = var0.method3176(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.method3176(1) != 0) {
            method850(var0, var1);
         }

         var3 = var0.method3176(13);
         var4 = var0.method3176(13);
         boolean var12 = var0.method3176(1) == 1;
         if(var12) {
            class45.field909[++class45.field908 - 1] = var1;
         }

         if(null != Client.cachedPlayers[var1]) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field256 = var1;
            if(class45.field900[var1] != null) {
               var6.method235(class45.field900[var1]);
            }

            var6.field641 = class45.field906[var1];
            var6.interacting = class45.field907[var1];
            var7 = class45.field911[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.field594[0] = class45.field899[var1];
            var6.field263 = (byte)var8;
            var6.method250((var9 << 13) + var3 - class114.baseX, var4 + (var10 << 13) - CombatInfo1.baseY);
            var6.field265 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.method3176(2);
         var4 = class45.field911[var1];
         class45.field911[var1] = (var4 & 268435455) + ((var3 + (var4 >> 28) & 3) << 28);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.method3176(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class45.field911[var1];
            var7 = var4 + (var11 >> 28) & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class45.field911[var1] = var9 + (var7 << 28) + (var8 << 14);
            return false;
         } else {
            var3 = var0.method3176(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class45.field911[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = (var7 >> 14) + var5 & 255;
            var10 = var7 + var11 & 255;
            class45.field911[var1] = (var9 << 14) + (var8 << 28) + var10;
            return false;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1386297669"
   )
   String method851(int var1) {
      return this.messages[var1];
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-2028434803"
   )
   boolean method852() {
      return this.field921;
   }

   ChatMessages() {
      this.field919 = new int[Client.field353.method3283(19)];
      this.messages = new String[Client.field353.method3283(15)];
      this.field918 = new boolean[this.field919.length];

      int var1;
      for(var1 = 0; var1 < this.field919.length; ++var1) {
         class188 var2 = class143.method2696(var1);
         this.field918[var1] = var2.field2762;
      }

      this.field917 = new boolean[this.messages.length];

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         class189 var3 = class3.method44(var1);
         this.field917[var1] = var3.field2768;
      }

      for(var1 = 0; var1 < this.field919.length; ++var1) {
         this.field919[var1] = -1;
      }

      this.method845();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "82"
   )
   void method864() {
      int var1;
      for(var1 = 0; var1 < this.field919.length; ++var1) {
         if(!this.field918[var1]) {
            this.field919[var1] = -1;
         }
      }

      for(var1 = 0; var1 < this.messages.length; ++var1) {
         if(!this.field917[var1]) {
            this.messages[var1] = null;
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)V",
      garbageValue = "45"
   )
   void method868(int var1, String var2) {
      this.messages[var1] = var2;
      if(this.field917[var1]) {
         this.field921 = true;
      }

   }
}
