import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("r")
final class class5 implements class0 {
   @ObfuscatedName("k")
   static ModIcon field40;

   @ObfuscatedName("gr")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   static void method18() {
      Client.secretPacketBuffer1.putOpcode(226);
      PacketBuffer var0 = Client.secretPacketBuffer1;
      int var1 = Client.isResized?2:1;
      var0.putByte(var1);
      Client.secretPacketBuffer1.putShort(class45.canvasWidth);
      Client.secretPacketBuffer1.putShort(CollisionData.canvasHeight);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILIndexFile;LIndexData;I)V",
      garbageValue = "1210692513"
   )
   static void method19(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = class236.field3247;
      Deque var5 = class236.field3247;
      synchronized(class236.field3247) {
         for(FileSystem var6 = (FileSystem)class236.field3247.getFront(); var6 != null; var6 = (FileSystem)class236.field3247.getNext()) {
            if((long)var0 == var6.hash && var6.index == var1 && var6.field3213 == 0) {
               var3 = var6.field3215;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.method4220(var1, var0, var3, true);
      } else {
         byte[] var9 = var1.method2997(var0);
         var2.method4220(var1, var0, var9, true);
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "-35"
   )
   static void method20(int var0, int var1, int var2, int var3) {
      for(class82 var4 = (class82)class82.field1349.getFront(); var4 != null; var4 = (class82)class82.field1349.getNext()) {
         if(var4.field1338 != -1 || var4.field1353 != null) {
            int var5 = 0;
            if(var1 > var4.field1352) {
               var5 += var1 - var4.field1352;
            } else if(var1 < var4.field1340) {
               var5 += var4.field1340 - var1;
            }

            if(var2 > var4.field1343) {
               var5 += var2 - var4.field1343;
            } else if(var2 < var4.field1341) {
               var5 += var4.field1341 - var2;
            }

            if(var5 - 64 <= var4.field1344 && Client.field1098 != 0 && var4.field1339 == var0) {
               var5 -= 64;
               if(var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field1344 - var5) * Client.field1098 / var4.field1344;
               if(var4.field1346 == null) {
                  if(var4.field1338 >= 0) {
                     SoundEffect var7 = SoundEffect.getTrack(class98.field1545, var4.field1338, 0);
                     if(var7 != null) {
                        class107 var8 = var7.method1942().method1989(class225.field2896);
                        class117 var9 = class117.method2229(var8, 100, var6);
                        var9.method2126(-1);
                        class19.field328.method1890(var9);
                        var4.field1346 = var9;
                     }
                  }
               } else {
                  var4.field1346.method2130(var6);
               }

               if(var4.field1351 == null) {
                  if(var4.field1353 != null && (var4.field1350 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.field1353.length);
                     SoundEffect var12 = SoundEffect.getTrack(class98.field1545, var4.field1353[var11], 0);
                     if(var12 != null) {
                        class107 var13 = var12.method1942().method1989(class225.field2896);
                        class117 var10 = class117.method2229(var13, 100, var6);
                        var10.method2126(0);
                        class19.field328.method1890(var10);
                        var4.field1351 = var10;
                        var4.field1350 = var4.field1347 + (int)(Math.random() * (double)(var4.field1348 - var4.field1347));
                     }
                  }
               } else {
                  var4.field1351.method2130(var6);
                  if(!var4.field1351.linked()) {
                     var4.field1351 = null;
                  }
               }
            } else {
               if(var4.field1346 != null) {
                  class19.field328.method1887(var4.field1346);
                  var4.field1346 = null;
               }

               if(var4.field1351 != null) {
                  class19.field328.method1887(var4.field1351);
                  var4.field1351 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "1708901919"
   )
   public static void method21(IndexDataBase var0) {
      FloorUnderlayDefinition.underlay_ref = var0;
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      signature = "([LWidget;II)V",
      garbageValue = "-451890668"
   )
   static final void method22(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null) {
            if(var3.type == 0) {
               if(var3.children != null) {
                  method22(var3.children, var1);
               }

               WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var4 != null) {
                  int var5 = var4.id;
                  if(class66.loadWidget(var5)) {
                     method22(class46.widgets[var5], var1);
                  }
               }
            }

            ScriptEvent var6;
            if(var1 == 0 && var3.field2731 != null) {
               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field857 = var3.field2731;
               class14.method76(var6);
            }

            if(var1 == 1 && var3.field2762 != null) {
               if(var3.index >= 0) {
                  Widget var7 = PacketBuffer.method3403(var3.id);
                  if(var7 == null || var7.children == null || var3.index >= var7.children.length || var7.children[var3.index] != var3) {
                     continue;
                  }
               }

               var6 = new ScriptEvent();
               var6.widget = var3;
               var6.field857 = var3.field2762;
               class14.method76(var6);
            }
         }
      }

   }
}
