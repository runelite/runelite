import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class169 {
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 2083805597
   )
   static int field2313;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IS)Liy;",
      garbageValue = "-8624"
   )
   public static FloorUnderlayDefinition method3168(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lev;IS)V",
      garbageValue = "17077"
   )
   public static final void method3165(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1900; ++var2) {
         if(var0.field1922[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1933[var3];
            int var7 = Model.field1933[var4];
            int var8 = Model.field1933[var5];
            int var9 = Model.field1949[var3];
            int var10 = Model.field1949[var4];
            int var11 = Model.field1949[var5];
            int var12 = Math.min(var6, Math.min(var7, var8)) - var1;
            int var13 = Math.max(var6, Math.max(var7, var8)) + var1;
            int var14 = Math.min(var9, Math.min(var10, var11)) - var1;
            int var15 = Math.max(var9, Math.max(var10, var11)) + var1;
            Actor.method1553(var12, var14, var13, var15, -49088);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILfv;Lib;B)V",
      garbageValue = "-78"
   )
   static void method3167(int var0, IndexFile var1, IndexData var2) {
      FileSystem var3 = new FileSystem();
      var3.field3180 = 1;
      var3.hash = (long)var0;
      var3.index = var1;
      var3.data = var2;
      Deque var4 = class236.field3220;
      synchronized(class236.field3220) {
         class236.field3220.addFront(var3);
      }

      Object var9 = class236.field3213;
      synchronized(class236.field3213) {
         if(class236.field3216 == 0) {
            class236.field3217 = new Thread(new class236());
            class236.field3217.setDaemon(true);
            class236.field3217.start();
            class236.field3217.setPriority(5);
         }

         class236.field3216 = 600;
      }
   }

   @ObfuscatedName("jl")
   @ObfuscatedSignature(
      signature = "(Lhn;I)I",
      garbageValue = "-1146901634"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Lba;ZI)V",
      garbageValue = "969938762"
   )
   static final void method3163(WidgetNode var0, boolean var1) {
      int var2 = var0.id;
      int var3 = (int)var0.hash;
      var0.unlink();
      if(var1 && var2 != -1 && XItemContainer.validInterfaces[var2]) {
         class67.widgetIndex.method4126(var2);
         if(class170.widgets[var2] != null) {
            boolean var6 = true;

            for(int var5 = 0; var5 < class170.widgets[var2].length; ++var5) {
               if(class170.widgets[var2][var5] != null) {
                  if(class170.widgets[var2][var5].type != 2) {
                     class170.widgets[var2][var5] = null;
                  } else {
                     var6 = false;
                  }
               }
            }

            if(var6) {
               class170.widgets[var2] = null;
            }

            XItemContainer.validInterfaces[var2] = false;
         }
      }

      for(IntegerNode var4 = (IntegerNode)Client.widgetFlags.method3564(); var4 != null; var4 = (IntegerNode)Client.widgetFlags.method3565()) {
         if((long)var2 == (var4.hash >> 48 & 65535L)) {
            var4.unlink();
         }
      }

      Widget var7 = WallObject.method2901(var3);
      if(var7 != null) {
         class48.method732(var7);
      }

      PacketBuffer.method3448();
      if(Client.widgetRoot != -1) {
         class14.method86(Client.widgetRoot, 1);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILef;[Lfl;B)V",
      garbageValue = "-49"
   )
   static final void method3164(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Region var8, CollisionData[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.getUSmart();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.getUSmart();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = WidgetNode.getObjectDefinition(var11);
               int var22 = var2 + class134.method2598(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               int var25 = var16 & 7;
               int var26 = var15 & 7;
               int var28 = var21.sizeX;
               int var29 = var21.sizeY;
               int var30;
               if((var20 & 1) == 1) {
                  var30 = var28;
                  var28 = var29;
                  var29 = var30;
               }

               int var27 = var7 & 3;
               int var24;
               if(var27 == 0) {
                  var24 = var26;
               } else if(var27 == 1) {
                  var24 = 7 - var25 - (var28 - 1);
               } else if(var27 == 2) {
                  var24 = 7 - var26 - (var29 - 1);
               } else {
                  var24 = var25;
               }

               var30 = var3 + var24;
               if(var22 > 0 && var30 > 0 && var22 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class62.tileSettings[1][var22][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionData var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class56.addObject(var1, var22, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }
}
