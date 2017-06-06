import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bd")
public class class71 implements Runnable {
   @ObfuscatedName("b")
   int[] field868;
   @ObfuscatedName("c")
   Object field869;
   @ObfuscatedName("i")
   boolean field870;
   @ObfuscatedName("v")
   int[] field871;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 66887879
   )
   int field872;
   @ObfuscatedName("gv")
   static SpritePixels[] field873;

   class71() {
      this.field870 = true;
      this.field869 = new Object();
      this.field872 = 0;
      this.field871 = new int[500];
      this.field868 = new int[500];
   }

   public void run() {
      for(; this.field870; class4.method9(50L)) {
         Object var1 = this.field869;
         synchronized(this.field869) {
            if(this.field872 < 500) {
               this.field871[this.field872] = class59.field737;
               this.field868[this.field872] = class59.field738;
               ++this.field872;
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LPacketBuffer;I)V",
      garbageValue = "797738668"
   )
   static final void method1096(PacketBuffer var0) {
      int var1 = 0;
      var0.method3389();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < class96.field1507; ++var2) {
         var3 = class96.field1508[var2];
         if((class96.field1504[var3] & 1) == 0) {
            if(var1 > 0) {
               --var1;
               class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
            } else {
               var4 = var0.method3397(1);
               if(var4 == 0) {
                  var1 = class226.method4079(var0);
                  class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
               } else {
                  class15.method79(var0, var3);
               }
            }
         }
      }

      var0.method3391();
      if(var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.method3389();

         for(var2 = 0; var2 < class96.field1507; ++var2) {
            var3 = class96.field1508[var2];
            if((class96.field1504[var3] & 1) != 0) {
               if(var1 > 0) {
                  --var1;
                  class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
               } else {
                  var4 = var0.method3397(1);
                  if(var4 == 0) {
                     var1 = class226.method4079(var0);
                     class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
                  } else {
                     class15.method79(var0, var3);
                  }
               }
            }
         }

         var0.method3391();
         if(var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.method3389();

            for(var2 = 0; var2 < class96.field1502; ++var2) {
               var3 = class96.field1515[var2];
               if((class96.field1504[var3] & 1) != 0) {
                  if(var1 > 0) {
                     --var1;
                     class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
                  } else {
                     var4 = var0.method3397(1);
                     if(var4 == 0) {
                        var1 = class226.method4079(var0);
                        class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
                     } else if(class51.method759(var0, var3)) {
                        class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
                     }
                  }
               }
            }

            var0.method3391();
            if(var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.method3389();

               for(var2 = 0; var2 < class96.field1502; ++var2) {
                  var3 = class96.field1515[var2];
                  if((class96.field1504[var3] & 1) == 0) {
                     if(var1 > 0) {
                        --var1;
                        class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
                     } else {
                        var4 = var0.method3397(1);
                        if(var4 == 0) {
                           var1 = class226.method4079(var0);
                           class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
                        } else if(class51.method759(var0, var3)) {
                           class96.field1504[var3] = (byte)(class96.field1504[var3] | 2);
                        }
                     }
                  }
               }

               var0.method3391();
               if(var1 != 0) {
                  throw new RuntimeException();
               } else {
                  class96.field1507 = 0;
                  class96.field1502 = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     class96.field1504[var2] = (byte)(class96.field1504[var2] >> 1);
                     Player var5 = Client.cachedPlayers[var2];
                     if(var5 != null) {
                        class96.field1508[++class96.field1507 - 1] = var2;
                     } else {
                        class96.field1515[++class96.field1502 - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("eu")
   @ObfuscatedSignature(
      signature = "(IZZZB)LIndexData;",
      garbageValue = "1"
   )
   static IndexData method1097(int var0, boolean var1, boolean var2, boolean var3) {
      IndexFile var4 = null;
      if(class155.field2269 != null) {
         var4 = new IndexFile(var0, class155.field2269, class211.field2610[var0], 1000000);
      }

      return new IndexData(var4, NPC.field1398, var0, var1, var2, var3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILIndexFile;LIndexData;I)V",
      garbageValue = "796169700"
   )
   static void method1098(int var0, IndexFile var1, IndexData var2) {
      class233 var3 = new class233();
      var3.field3207 = 1;
      var3.hash = (long)var0;
      var3.field3199 = var1;
      var3.field3200 = var2;
      Deque var4 = class236.field3238;
      synchronized(class236.field3238) {
         class236.field3238.method3571(var3);
      }

      Object var9 = class236.field3234;
      synchronized(class236.field3234) {
         if(class236.field3236 == 0) {
            class111.field1676 = new Thread(new class236());
            class111.field1676.setDaemon(true);
            class111.field1676.start();
            class111.field1676.setPriority(5);
         }

         class236.field3236 = 600;
      }
   }
}
