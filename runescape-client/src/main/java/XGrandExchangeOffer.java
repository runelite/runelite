import java.io.File;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("m")
@Implements("XGrandExchangeOffer")
public class XGrandExchangeOffer {
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1782929383
   )
   @Export("totalQuantity")
   public int totalQuantity;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 464534417
   )
   @Export("itemId")
   public int itemId;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -753038671
   )
   @Export("price")
   public int price;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1145602939
   )
   @Export("spent")
   public int spent;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -887668267
   )
   @Export("quantitySold")
   public int quantitySold;
   @ObfuscatedName("eu")
   @Export("rssocket")
   static RSSocket rssocket;
   @ObfuscatedName("rr")
   @ObfuscatedGetter(
      intValue = 1010289929
   )
   static int field304;
   @ObfuscatedName("i")
   @Export("progress")
   byte progress;
   @ObfuscatedName("ii")
   @Export("localPlayer")
   static Player localPlayer;

   @ObfuscatedSignature(
      signature = "(LBuffer;Z)V",
      garbageValue = "0"
   )
   public XGrandExchangeOffer(Buffer var1, boolean var2) {
      this.progress = var1.readByte();
      this.itemId = var1.readUnsignedShort();
      this.price = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.quantitySold = var1.readInt();
      this.spent = var1.readInt();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1038223099"
   )
   public int method96() {
      return (this.progress & 8) == 8?1:0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "50"
   )
   void method98(int var1) {
      this.progress &= -8;
      this.progress = (byte)(this.progress | var1 & 7);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1817108742"
   )
   void method99(int var1) {
      this.progress &= -9;
      if(var1 == 1) {
         this.progress = (byte)(this.progress | 8);
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "-1420395427"
   )
   public static boolean method105(char var0) {
      if((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if(var0 != 0) {
            char[] var1 = class266.field3658;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if(var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1736940436"
   )
   static void method109(int var0, int var1) {
      class89 var2 = class7.field235;
      class215.menuAction(var2.field1381, var2.field1394, var2.field1382, var2.field1391, var2.field1384, var2.field1384, var0, var1);
      class7.field235 = null;
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-537079803"
   )
   static void method110() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         if(GameObject.method2938(Client.menuTypes[var0])) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var1 = var0; var1 < Client.menuOptionCount - 1; ++var1) {
                  Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
                  Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
                  Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
                  Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
                  Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
                  Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-1"
   )
   public int method111() {
      return this.progress & 7;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "-754055853"
   )
   @Export("getPreferencesFile")
   public static FileOnDisk getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(class155.field2224, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class155.field2230 == 33) {
         var4 = "_rc";
      } else if(class155.field2230 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class60.field735, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1556979128"
   )
   public static boolean method113(int var0) {
      return (var0 >> 21 & 1) != 0;
   }

   public XGrandExchangeOffer() {
   }
}
