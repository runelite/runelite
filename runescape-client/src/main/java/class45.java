import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class45 extends WorldMapData {
   @ObfuscatedName("d")
   HashSet field571;
   @ObfuscatedName("r")
   HashSet field570;
   @ObfuscatedName("p")
   List field569;

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(Lgg;Lgg;Lgg;IZI)V",
      garbageValue = "2057123239"
   )
   void method677(Buffer var1, Buffer var2, Buffer var3, int var4, boolean var5) {
      this.loadMapData(var1, var4);
      int var6 = var3.readUnsignedShort();
      this.field571 = new HashSet(var6);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         class22 var8 = new class22();

         try {
            var8.method170(var2, var3);
         } catch (IllegalStateException var13) {
            continue;
         }

         this.field571.add(var8);
      }

      var7 = var3.readUnsignedShort();
      this.field570 = new HashSet(var7);

      for(int var11 = 0; var11 < var7; ++var11) {
         class46 var9 = new class46();

         try {
            var9.method710(var2, var3);
         } catch (IllegalStateException var12) {
            continue;
         }

         this.field570.add(var9);
      }

      this.method674(var2, var5);
   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(Lgg;ZI)V",
      garbageValue = "-1845209952"
   )
   void method674(Buffer var1, boolean var2) {
      this.field569 = new LinkedList();
      int var3 = var1.readUnsignedShort();

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var1.method3614();
         Coordinates var6 = new Coordinates(var1.readInt());
         boolean var7 = var1.readUnsignedByte() == 1;
         if(var2 || !var7) {
            this.field569.add(new class25(var5, var6));
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;Ljr;I)V",
      garbageValue = "1246104007"
   )
   public static void method679(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.SpotAnimationDefinition_indexCache = var0;
      TotalQuantityComparator.SpotAnimationDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-635009323"
   )
   public static String method682(CharSequence var0) {
      int var2 = var0.length();
      char[] var3 = new char[var2];

      for(int var4 = 0; var4 < var2; ++var4) {
         var3[var4] = '*';
      }

      String var1 = new String(var3);
      return var1;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "28"
   )
   static final void method673() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if(var0.hitpoints == 0) {
            if(var0.field1130 >= 0) {
               var2 = var0.field1130;
               var3 = var0.field1132;
               var4 = class80.getObjectDefinition(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method5080(var3);
               if(!var1) {
                  continue;
               }
            }

            Preferences.method1780(var0.level, var0.type, var0.x, var0.y, var0.field1130, var0.field1128, var0.field1132);
            var0.unlink();
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102) {
               if(var0.id >= 0) {
                  var2 = var0.id;
                  var3 = var0.field1135;
                  var4 = class80.getObjectDefinition(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method5080(var3);
                  if(!var1) {
                     continue;
                  }
               }

               Preferences.method1780(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1135);
               var0.delay = -1;
               if(var0.id == var0.field1130 && var0.field1130 == -1) {
                  var0.unlink();
               } else if(var0.id == var0.field1130 && var0.field1128 == var0.orientation && var0.field1135 == var0.field1132) {
                  var0.unlink();
               }
            }
         }
      }

   }

   @ObfuscatedName("ix")
   @ObfuscatedSignature(
      signature = "([Liz;IIIZS)V",
      garbageValue = "223"
   )
   static void method680(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if(var6 != null && var6.parentId == var1) {
            class90.method1991(var6, var2, var3, var4);
            class297.method5347(var6, var2, var3);
            if(var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if(var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if(var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if(var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if(var6.type == 0) {
               class33.method372(var0, var6, var4);
            }
         }
      }

   }
}
