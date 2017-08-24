import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
public class class13 {
   @ObfuscatedName("j")
   public static Comparator field283;
   @ObfuscatedName("a")
   public static Comparator field284;
   @ObfuscatedName("r")
   public static Comparator field285;
   @ObfuscatedName("o")
   public static Comparator field291;
   @ObfuscatedName("nv")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   static class277 field293;
   @ObfuscatedName("bs")
   static String field282;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 984929339
   )
   @Export("clanChatCount")
   static int clanChatCount;
   @ObfuscatedName("i")
   public final List field289;

   static {
      field283 = new class19();
      new class12();
      field284 = new class17();
      field285 = new class18();
      field291 = new class15();
   }

   @ObfuscatedSignature(
      signature = "(Lfp;Z)V",
      garbageValue = "1"
   )
   public class13(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.field289 = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.field289.add(new class14(var1, var5, var3));
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "-2130908141"
   )
   public void method77(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.field289, var1);
      } else {
         Collections.sort(this.field289, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1933631958"
   )
   public static boolean method80() {
      try {
         if(class204.field2507 == 2) {
            if(Coordinates.field2620 == null) {
               Coordinates.field2620 = Track1.getMusicFile(class204.field2508, class204.field2509, ItemContainer.field787);
               if(Coordinates.field2620 == null) {
                  return false;
               }
            }

            if(class204.field2511 == null) {
               class204.field2511 = new class111(class204.field2506, class204.field2512);
            }

            if(class225.field2856.method3778(Coordinates.field2620, class204.field2504, class204.field2511, 22050)) {
               class225.field2856.method3769();
               class225.field2856.method3793(class204.field2510);
               class225.field2856.method3795(Coordinates.field2620, Varcs.field1528);
               class204.field2507 = 0;
               Coordinates.field2620 = null;
               class204.field2511 = null;
               class204.field2508 = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class225.field2856.method3772();
         class204.field2507 = 0;
         Coordinates.field2620 = null;
         class204.field2511 = null;
         class204.field2508 = null;
      }

      return false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1685600675"
   )
   @Export("loadWidget")
   public static boolean loadWidget(int var0) {
      if(class2.validInterfaces[var0]) {
         return true;
      } else if(!Coordinates.widgetIndex.containsFile(var0)) {
         return false;
      } else {
         int var1 = Coordinates.widgetIndex.fileCount(var0);
         if(var1 == 0) {
            class2.validInterfaces[var0] = true;
            return true;
         } else {
            if(class268.widgets[var0] == null) {
               class268.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(class268.widgets[var0][var2] == null) {
                  byte[] var3 = Coordinates.widgetIndex.getConfigData(var0, var2);
                  if(var3 != null) {
                     class268.widgets[var0][var2] = new Widget();
                     class268.widgets[var0][var2].id = var2 + (var0 << 16);
                     if(var3[0] == -1) {
                        class268.widgets[var0][var2].decodeActive(new Buffer(var3));
                     } else {
                        class268.widgets[var0][var2].decode(new Buffer(var3));
                     }
                  }
               }
            }

            class2.validInterfaces[var0] = true;
            return true;
         }
      }
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Lhx;IIZI)V",
      garbageValue = "-494766702"
   )
   static void method82(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if(var0.field2665 == 0) {
         var0.width = var0.originalWidth;
      } else if(var0.field2665 == 1) {
         var0.width = var1 - var0.originalWidth;
      } else if(var0.field2665 == 2) {
         var0.width = var0.originalWidth * var1 >> 14;
      }

      if(var0.buttonType == 0) {
         var0.height = var0.field2670;
      } else if(var0.buttonType == 1) {
         var0.height = var2 - var0.field2670;
      } else if(var0.buttonType == 2) {
         var0.height = var2 * var0.field2670 >> 14;
      }

      if(var0.field2665 == 4) {
         var0.width = var0.height * var0.field2717 / var0.field2676;
      }

      if(var0.buttonType == 4) {
         var0.height = var0.field2676 * var0.width / var0.field2717;
      }

      if(Client.field1101 && var0.type == 0) {
         if(var0.height < 5 && var0.width < 5) {
            var0.height = 5;
            var0.width = 5;
         } else {
            if(var0.height <= 0) {
               var0.height = 5;
            }

            if(var0.width <= 0) {
               var0.width = 5;
            }
         }
      }

      if(var0.contentType == 1337) {
         Client.field1103 = var0;
      }

      if(var3 && var0.field2767 != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.field864 = var0.field2767;
         Client.field1130.addFront(var6);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[BLfx;I)V",
      garbageValue = "-1282322656"
   )
   static void method85(int var0, byte[] var1, IndexFile var2) {
      FileSystem var3 = new FileSystem();
      var3.field3205 = 0;
      var3.hash = (long)var0;
      var3.field3206 = var1;
      var3.index = var2;
      Deque var4 = class237.field3243;
      synchronized(class237.field3243) {
         class237.field3243.addFront(var3);
      }

      IndexFile.method3099();
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1756295529"
   )
   static void method83() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.field1077[var3] = Client.field1077[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
