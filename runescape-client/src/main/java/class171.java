import java.awt.FontMetrics;
import java.io.IOException;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.zip.CRC32;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public class class171 extends class170 {
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1037440633
   )
   int field2735 = -1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1443650153
   )
   int field2736;
   @ObfuscatedName("f")
   volatile boolean field2737 = false;
   @ObfuscatedName("b")
   boolean field2738 = false;
   @ObfuscatedName("z")
   class137 field2739;
   @ObfuscatedName("a")
   static CRC32 field2740 = new CRC32();
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1960030995
   )
   int field2741;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2130071093
   )
   int field2742;
   @ObfuscatedName("q")
   class137 field2744;
   @ObfuscatedName("t")
   volatile boolean[] field2745;
   @ObfuscatedName("bf")
   protected static FontMetrics field2746;

   @ObfuscatedName("cw")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1980170444"
   )
   int method3367(int var1) {
      return super.field2724[var1] != null?100:(this.field2745[var1]?100:XClanMember.method578(this.field2736, var1));
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "295305501"
   )
   public int method3368() {
      if(this.field2737) {
         return 100;
      } else if(null != super.field2724) {
         return 99;
      } else {
         int var1 = XClanMember.method578(255, this.field2736);
         if(var1 >= 100) {
            var1 = 99;
         }

         return var1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "-25734"
   )
   void vmethod3369(int var1) {
      int var2 = this.field2736;
      long var3 = (long)((var2 << 16) + var1);
      class175 var5 = (class175)class174.field2767.method3812(var3);
      if(null != var5) {
         class174.field2765.method3904(var5);
      }

   }

   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "2007053322"
   )
   public void method3371(int var1, int var2) {
      this.field2741 = var1;
      this.field2742 = var2;
      if(null != this.field2744) {
         int var3 = this.field2736;
         class137 var4 = this.field2744;
         byte[] var6 = null;
         Deque var7 = class173.field2756;
         synchronized(class173.field2756) {
            for(class172 var8 = (class172)class173.field2756.method3845(); null != var8; var8 = (class172)class173.field2756.method3847()) {
               if(var8.hash == (long)var3 && var4 == var8.field2750 && var8.field2747 == 0) {
                  var6 = var8.field2748;
                  break;
               }
            }
         }

         if(null != var6) {
            this.method3373(var4, var3, var6, true);
         } else {
            byte[] var11 = var4.method2899(var3);
            this.method3373(var4, var3, var11, true);
         }
      } else {
         MessageNode.method764(this, 255, this.field2736, this.field2741, (byte)0, true);
      }

   }

   @ObfuscatedName("ch")
   @ObfuscatedSignature(
      signature = "(I[BZZB)V",
      garbageValue = "-72"
   )
   public void method3372(int var1, byte[] var2, boolean var3, boolean var4) {
      if(var3) {
         if(this.field2737) {
            throw new RuntimeException();
         }

         if(null != this.field2744) {
            int var5 = this.field2736;
            class137 var6 = this.field2744;
            class172 var7 = new class172();
            var7.field2747 = 0;
            var7.hash = (long)var5;
            var7.field2748 = var2;
            var7.field2750 = var6;
            Deque var8 = class173.field2756;
            synchronized(class173.field2756) {
               class173.field2756.method3865(var7);
            }

            class158.method3192();
         }

         this.method3346(var2);
         this.method3388();
      } else {
         var2[var2.length - 2] = (byte)(super.field2725[var1] >> 8);
         var2[var2.length - 1] = (byte)super.field2725[var1];
         if(null != this.field2739) {
            class137 var11 = this.field2739;
            class172 var14 = new class172();
            var14.field2747 = 0;
            var14.hash = (long)var1;
            var14.field2748 = var2;
            var14.field2750 = var11;
            Deque var15 = class173.field2756;
            synchronized(class173.field2756) {
               class173.field2756.method3865(var14);
            }

            class158.method3192();
            this.field2745[var1] = true;
         }

         if(var4) {
            super.field2724[var1] = Ignore.method103(var2, false);
         }
      }

   }

   @ObfuscatedName("cu")
   @ObfuscatedSignature(
      signature = "(Lclass137;I[BZB)V",
      garbageValue = "100"
   )
   public void method3373(class137 var1, int var2, byte[] var3, boolean var4) {
      int var5;
      if(this.field2744 == var1) {
         if(this.field2737) {
            throw new RuntimeException();
         }

         if(null == var3) {
            MessageNode.method764(this, 255, this.field2736, this.field2741, (byte)0, true);
            return;
         }

         field2740.reset();
         field2740.update(var3, 0, var3.length);
         var5 = (int)field2740.getValue();
         Buffer var6 = new Buffer(class134.method2883(var3));
         int var7 = var6.method2544();
         if(var7 != 5 && var7 != 6) {
            throw new RuntimeException(var7 + "," + this.field2736 + "," + var2);
         }

         int var8 = 0;
         if(var7 >= 6) {
            var8 = var6.method2549();
         }

         if(var5 != this.field2741 || var8 != this.field2742) {
            MessageNode.method764(this, 255, this.field2736, this.field2741, (byte)0, true);
            return;
         }

         this.method3346(var3);
         this.method3388();
      } else {
         if(!var4 && var2 == this.field2735) {
            this.field2737 = true;
         }

         if(null == var3 || var3.length <= 2) {
            this.field2745[var2] = false;
            if(this.field2738 || var4) {
               MessageNode.method764(this, this.field2736, var2, super.field2730[var2], (byte)2, var4);
            }

            return;
         }

         field2740.reset();
         field2740.update(var3, 0, var3.length - 2);
         var5 = (int)field2740.getValue();
         int var9 = (var3[var3.length - 1] & 255) + ((var3[var3.length - 2] & 255) << 8);
         if(var5 != super.field2730[var2] || super.field2725[var2] != var9) {
            this.field2745[var2] = false;
            if(this.field2738 || var4) {
               MessageNode.method764(this, this.field2736, var2, super.field2730[var2], (byte)2, var4);
            }

            return;
         }

         this.field2745[var2] = true;
         if(var4) {
            super.field2724[var2] = Ignore.method103(var3, false);
         }
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2136277192"
   )
   public int method3376() {
      int var1 = 0;
      int var2 = 0;

      int var3;
      for(var3 = 0; var3 < super.field2724.length; ++var3) {
         if(super.field2720[var3] > 0) {
            var1 += 100;
            var2 += this.method3367(var3);
         }
      }

      if(var1 == 0) {
         return 100;
      } else {
         var3 = var2 * 100 / var1;
         return var3;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-78"
   )
   void vmethod3380(int var1) {
      if(this.field2739 != null && null != this.field2745 && this.field2745[var1]) {
         class137 var2 = this.field2739;
         byte[] var4 = null;
         Deque var5 = class173.field2756;
         synchronized(class173.field2756) {
            for(class172 var6 = (class172)class173.field2756.method3845(); null != var6; var6 = (class172)class173.field2756.method3847()) {
               if((long)var1 == var6.hash && var2 == var6.field2750 && var6.field2747 == 0) {
                  var4 = var6.field2748;
                  break;
               }
            }
         }

         if(var4 != null) {
            this.method3373(var2, var1, var4, true);
         } else {
            byte[] var9 = var2.method2899(var1);
            this.method3373(var2, var1, var9, true);
         }
      } else {
         MessageNode.method764(this, this.field2736, var1, super.field2730[var1], (byte)2, true);
      }

   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1582966403"
   )
   void method3388() {
      this.field2745 = new boolean[super.field2724.length];

      int var1;
      for(var1 = 0; var1 < this.field2745.length; ++var1) {
         this.field2745[var1] = false;
      }

      if(this.field2739 == null) {
         this.field2737 = true;
      } else {
         this.field2735 = -1;

         for(var1 = 0; var1 < this.field2745.length; ++var1) {
            if(super.field2720[var1] > 0) {
               class137 var2 = this.field2739;
               class172 var4 = new class172();
               var4.field2747 = 1;
               var4.hash = (long)var1;
               var4.field2750 = var2;
               var4.field2749 = this;
               Deque var5 = class173.field2756;
               synchronized(class173.field2756) {
                  class173.field2756.method3865(var4);
               }

               class158.method3192();
               this.field2735 = var1;
            }
         }

         if(this.field2735 == -1) {
            this.field2737 = true;
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-446020147"
   )
   static void method3395() {
      for(class24 var0 = (class24)class24.field634.method3845(); null != var0; var0 = (class24)class24.field634.method3847()) {
         if(null != var0.field638) {
            var0.method566();
         }
      }

   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1168814624"
   )
   static final boolean method3398() {
      if(null == ObjectComposition.field993) {
         return false;
      } else {
         int var2;
         String var21;
         try {
            int var0 = ObjectComposition.field993.method3026();
            if(var0 == 0) {
               return false;
            }

            if(Client.packetOpcode == -1) {
               ObjectComposition.field993.method3027(Client.field347.payload, 0, 1);
               Client.field347.offset = 0;
               Client.packetOpcode = Client.field347.method2788();
               Client.field348 = class191.field3107[Client.packetOpcode];
               --var0;
            }

            if(Client.field348 == -1) {
               if(var0 <= 0) {
                  return false;
               }

               ObjectComposition.field993.method3027(Client.field347.payload, 0, 1);
               Client.field348 = Client.field347.payload[0] & 255;
               --var0;
            }

            if(Client.field348 == -2) {
               if(var0 <= 1) {
                  return false;
               }

               ObjectComposition.field993.method3027(Client.field347.payload, 0, 2);
               Client.field347.offset = 0;
               Client.field348 = Client.field347.method2546();
               var0 -= 2;
            }

            if(var0 < Client.field348) {
               return false;
            }

            Client.field347.offset = 0;
            ObjectComposition.field993.method3027(Client.field347.payload, 0, Client.field348);
            Client.field350 = 0;
            Client.field354 = Client.field421;
            Client.field421 = Client.field352 * -1;
            Client.field352 = Client.packetOpcode * -1;
            int var1;
            if(Client.packetOpcode == 80) {
               var1 = Client.field347.method2528();
               var2 = Client.field347.method2715();
               class179.settings[var1] = var2;
               if(class179.widgetSettings[var1] != var2) {
                  class179.widgetSettings[var1] = var2;
               }

               RSCanvas.method2982(var1);
               Client.field486[++Client.field426 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 188) {
               World var93 = new World();
               var93.address = Client.field347.method2552();
               var93.id = Client.field347.method2546();
               var2 = Client.field347.method2549();
               var93.mask = var2;
               class117.setGameState(45);
               ObjectComposition.field993.method3029();
               ObjectComposition.field993 = null;
               Friend.selectWorld(var93);
               Client.packetOpcode = -1;
               return false;
            }

            int var3;
            int var4;
            int var5;
            int var6;
            int var54;
            if(Client.packetOpcode == 231) {
               Client.field548 = true;
               class26.field657 = Client.field347.method2544();
               class189.field3065 = Client.field347.method2544();
               Client.field363 = Client.field347.method2546();
               Client.field549 = Client.field347.method2544();
               class9.field172 = Client.field347.method2544();
               if(class9.field172 >= 100) {
                  var1 = class26.field657 * 128 + 64;
                  var2 = class189.field3065 * 128 + 64;
                  var3 = class16.method191(var1, var2, class173.plane) - Client.field363;
                  var4 = var1 - ChatLineBuffer.cameraX;
                  var5 = var3 - class28.cameraZ;
                  var6 = var2 - class35.cameraY;
                  var54 = (int)Math.sqrt((double)(var4 * var4 + var6 * var6));
                  class22.cameraPitch = (int)(Math.atan2((double)var5, (double)var54) * 325.949D) & 2047;
                  class168.cameraYaw = (int)(Math.atan2((double)var4, (double)var6) * -325.949D) & 2047;
                  if(class22.cameraPitch < 128) {
                     class22.cameraPitch = 128;
                  }

                  if(class22.cameraPitch > 383) {
                     class22.cameraPitch = 383;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 223 || Client.packetOpcode == 40 || Client.packetOpcode == 217 || Client.packetOpcode == 252 || Client.packetOpcode == 180 || Client.packetOpcode == 12 || Client.packetOpcode == 122 || Client.packetOpcode == 61 || Client.packetOpcode == 243 || Client.packetOpcode == 28) {
               class5.method70();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 95) {
               Sequence.method902();
               Client.packetOpcode = -1;
               return false;
            }

            if(Client.packetOpcode == 202) {
               Client.field403 = Client.field347.method2544();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 19) {
               var1 = Client.field347.method2546();
               var2 = Client.field347.method2544();
               var3 = Client.field347.method2546();
               if(Client.field547 != 0 && var2 != 0 && Client.field542 < 50) {
                  Client.field543[Client.field542] = var1;
                  Client.field544[Client.field542] = var2;
                  Client.field545[Client.field542] = var3;
                  Client.field554[Client.field542] = null;
                  Client.field546[Client.field542] = 0;
                  ++Client.field542;
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var63;
            String var75;
            String var79;
            if(Client.packetOpcode == 0) {
               while(Client.field347.offset < Client.field348) {
                  var1 = Client.field347.method2544();
                  var63 = (var1 & 1) == 1;
                  var75 = Client.field347.method2552();
                  var79 = Client.field347.method2552();
                  Client.field347.method2552();

                  for(var5 = 0; var5 < Client.ignoreCount; ++var5) {
                     Ignore var88 = Client.ignores[var5];
                     if(var63) {
                        if(var79.equals(var88.name)) {
                           var88.name = var75;
                           var88.previousName = var79;
                           var75 = null;
                           break;
                        }
                     } else if(var75.equals(var88.name)) {
                        var88.name = var75;
                        var88.previousName = var79;
                        var75 = null;
                        break;
                     }
                  }

                  if(null != var75 && Client.ignoreCount < 400) {
                     Ignore var100 = new Ignore();
                     Client.ignores[Client.ignoreCount] = var100;
                     var100.name = var75;
                     var100.previousName = var79;
                     ++Client.ignoreCount;
                  }
               }

               Client.field493 = Client.field485;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 47) {
               class34.field779 = 0;

               for(var1 = 0; var1 < 2048; ++var1) {
                  class34.field784[var1] = null;
                  class34.field777[var1] = 1;
               }

               for(var1 = 0; var1 < 2048; ++var1) {
                  Client.cachedPlayers[var1] = null;
               }

               class4.method52(Client.field347);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 240) {
               var1 = Client.field347.method2544();
               if(Client.field347.method2544() == 0) {
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer();
                  Client.field347.offset += 18;
               } else {
                  --Client.field347.offset;
                  Client.grandExchangeOffers[var1] = new XGrandExchangeOffer(Client.field347, false);
               }

               Client.field575 = Client.field485;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 78) {
               var1 = Client.field347.method2549();
               WidgetNode var106 = (WidgetNode)Client.componentTable.method3812((long)var1);
               if(var106 != null) {
                  class187.method3741(var106, true);
               }

               if(null != Client.field464) {
                  class32.method673(Client.field464);
                  Client.field464 = null;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 26) {
               byte var74 = Client.field347.method2545();
               var2 = Client.field347.method2572();
               class179.settings[var2] = var74;
               if(class179.widgetSettings[var2] != var74) {
                  class179.widgetSettings[var2] = var74;
               }

               RSCanvas.method2982(var2);
               Client.field486[++Client.field426 - 1 & 31] = var2;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 106) {
               class48.method996();
               var1 = Client.field347.method2544();
               var2 = Client.field347.method2590();
               var3 = Client.field347.method2653();
               Client.skillExperiences[var1] = var2;
               Client.boostedSkillLevels[var1] = var3;
               Client.realSkillLevels[var1] = 1;

               for(var4 = 0; var4 < 98; ++var4) {
                  if(var2 >= class158.field2345[var4]) {
                     Client.realSkillLevels[var1] = var4 + 2;
                  }
               }

               Client.field490[++Client.field491 - 1 & 31] = var1;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 5) {
               GroundObject.xteaChanged(true);
               Client.field347.method2788();
               var1 = Client.field347.method2546();
               class24.method576(Client.field347, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 131) {
               for(var1 = 0; var1 < class56.field1220; ++var1) {
                  class56 var105 = class48.method982(var1);
                  if(null != var105) {
                     class179.settings[var1] = 0;
                     class179.widgetSettings[var1] = 0;
                  }
               }

               class48.method996();
               Client.field426 += 32;
               Client.packetOpcode = -1;
               return true;
            }

            int var13;
            int var16;
            String var27;
            int var58;
            int var67;
            if(Client.packetOpcode == 222) {
               class125 var91 = Client.field347;
               var2 = Client.field348;
               ClassInfo var112 = new ClassInfo();
               var112.field3179 = var91.method2544();
               var112.field3184 = var91.method2549();
               var112.field3178 = new int[var112.field3179];
               var112.field3181 = new int[var112.field3179];
               var112.fields = new Field[var112.field3179];
               var112.field3183 = new int[var112.field3179];
               var112.methods = new Method[var112.field3179];
               var112.args = new byte[var112.field3179][][];

               for(var4 = 0; var4 < var112.field3179; ++var4) {
                  try {
                     var5 = var91.method2544();
                     String var84;
                     if(var5 != 0 && var5 != 1 && var5 != 2) {
                        if(var5 == 3 || var5 == 4) {
                           var84 = var91.method2552();
                           var27 = var91.method2552();
                           var58 = var91.method2544();
                           String[] var65 = new String[var58];

                           for(var67 = 0; var67 < var58; ++var67) {
                              var65[var67] = var91.method2552();
                           }

                           String var103 = var91.method2552();
                           byte[][] var11 = new byte[var58][];
                           if(var5 == 3) {
                              for(int var68 = 0; var68 < var58; ++var68) {
                                 var13 = var91.method2549();
                                 var11[var68] = new byte[var13];
                                 var91.method2555(var11[var68], 0, var13);
                              }
                           }

                           var112.field3178[var4] = var5;
                           Class[] var110 = new Class[var58];

                           for(var13 = 0; var13 < var58; ++var13) {
                              var110[var13] = class152.method3165(var65[var13]);
                           }

                           Class var113 = class152.method3165(var103);
                           if(class152.method3165(var84).getClassLoader() == null) {
                              throw new SecurityException();
                           }

                           Method[] var69 = class152.method3165(var84).getDeclaredMethods();
                           Method[] var71 = var69;

                           for(var16 = 0; var16 < var71.length; ++var16) {
                              Method var72 = var71[var16];
                              if(var72.getName().equals(var27)) {
                                 Class[] var73 = var72.getParameterTypes();
                                 if(var73.length == var110.length) {
                                    boolean var19 = true;

                                    for(int var20 = 0; var20 < var110.length; ++var20) {
                                       if(var110[var20] != var73[var20]) {
                                          var19 = false;
                                          break;
                                       }
                                    }

                                    if(var19 && var113 == var72.getReturnType()) {
                                       var112.methods[var4] = var72;
                                    }
                                 }
                              }
                           }

                           var112.args[var4] = var11;
                        }
                     } else {
                        var84 = var91.method2552();
                        var27 = var91.method2552();
                        var58 = 0;
                        if(var5 == 1) {
                           var58 = var91.method2549();
                        }

                        var112.field3178[var4] = var5;
                        var112.field3183[var4] = var58;
                        if(class152.method3165(var84).getClassLoader() == null) {
                           throw new SecurityException();
                        }

                        var112.fields[var4] = class152.method3165(var84).getDeclaredField(var27);
                     }
                  } catch (ClassNotFoundException var41) {
                     var112.field3181[var4] = -1;
                  } catch (SecurityException var42) {
                     var112.field3181[var4] = -2;
                  } catch (NullPointerException var43) {
                     var112.field3181[var4] = -3;
                  } catch (Exception var44) {
                     var112.field3181[var4] = -4;
                  } catch (Throwable var45) {
                     var112.field3181[var4] = -5;
                  }
               }

               class214.field3187.method3878(var112);
               Client.packetOpcode = -1;
               return true;
            }

            Widget var23;
            if(Client.packetOpcode == 206) {
               var1 = Client.field347.method2570();
               var2 = Client.field347.method2589();
               var3 = Client.field347.method2570();
               var23 = class173.method3412(var2);
               if(var3 != var23.field2842 || var1 != var23.field2812 || var23.field2807 != 0 || var23.field2808 != 0) {
                  var23.field2842 = var3;
                  var23.field2812 = var1;
                  var23.field2807 = 0;
                  var23.field2808 = 0;
                  class32.method673(var23);
                  class117.method2481(var23);
                  if(var23.type == 0) {
                     class130.method2850(Widget.widgets[var2 >> 16], var23, false);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var77;
            if(Client.packetOpcode == 22) {
               var1 = Client.field347.method2715();
               var2 = Client.field347.method2725();
               var77 = class173.method3412(var1);
               if(var77 != null && var77.type == 0) {
                  if(var2 > var77.scrollHeight - var77.height) {
                     var2 = var77.scrollHeight - var77.height;
                  }

                  if(var2 < 0) {
                     var2 = 0;
                  }

                  if(var77.scrollY != var2) {
                     var77.scrollY = var2;
                     class32.method673(var77);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            WidgetNode var82;
            Widget var94;
            if(Client.packetOpcode == 121) {
               var1 = Client.field347.method2549();
               var2 = Client.field347.method2590();
               WidgetNode var109 = (WidgetNode)Client.componentTable.method3812((long)var2);
               var82 = (WidgetNode)Client.componentTable.method3812((long)var1);
               if(var82 != null) {
                  class187.method3741(var82, null == var109 || var109.id != var82.id);
               }

               if(null != var109) {
                  var109.unlink();
                  Client.componentTable.method3813(var109, (long)var1);
               }

               var94 = class173.method3412(var2);
               if(var94 != null) {
                  class32.method673(var94);
               }

               var94 = class173.method3412(var1);
               if(var94 != null) {
                  class32.method673(var94);
                  class130.method2850(Widget.widgets[var94.id >>> 16], var94, true);
               }

               if(Client.widgetRoot != -1) {
                  var6 = Client.widgetRoot;
                  if(class14.method172(var6)) {
                     class49.method1007(Widget.widgets[var6], 1);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 168) {
               var1 = Client.field347.method2549();
               var2 = Client.field347.method2546();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var77 = class173.method3412(var1);
               } else {
                  var77 = null;
               }

               for(; Client.field347.offset < Client.field348; class18.method200(var2, var4, var5 - 1, var6)) {
                  var4 = Client.field347.method2573();
                  var5 = Client.field347.method2546();
                  var6 = 0;
                  if(var5 != 0) {
                     var6 = Client.field347.method2544();
                     if(var6 == 255) {
                        var6 = Client.field347.method2549();
                     }
                  }

                  if(var77 != null && var4 >= 0 && var4 < var77.itemIds.length) {
                     var77.itemIds[var4] = var5;
                     var77.itemQuantities[var4] = var6;
                  }
               }

               if(var77 != null) {
                  class32.method673(var77);
               }

               class48.method996();
               Client.field488[++Client.field489 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            boolean var48;
            if(Client.packetOpcode == 165) {
               var48 = Client.field347.method2544() == 1;
               var2 = Client.field347.method2715();
               var77 = class173.method3412(var2);
               if(var77.isHidden != var48) {
                  var77.isHidden = var48;
                  class32.method673(var77);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 53) {
               Client.field347.offset += 28;
               if(Client.field347.method2567()) {
                  class59.method1257(Client.field347, Client.field347.offset - 28);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 138) {
               CollisionData.method2456(true);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 124) {
               Client.field317 = Client.field347.method2725() * 30;
               Client.field497 = Client.field485;
               Client.packetOpcode = -1;
               return true;
            }

            long var55;
            if(Client.packetOpcode == 212) {
               var1 = Client.field347.method2549();
               var2 = Client.field347.method2589();
               var3 = Client.field347.method2528();
               if(var3 == '\uffff') {
                  var3 = -1;
               }

               var4 = Client.field347.method2572();
               if(var4 == '\uffff') {
                  var4 = -1;
               }

               for(var5 = var3; var5 <= var4; ++var5) {
                  var55 = ((long)var1 << 32) + (long)var5;
                  Node var114 = Client.widgetFlags.method3812(var55);
                  if(var114 != null) {
                     var114.unlink();
                  }

                  Client.widgetFlags.method3813(new class204(var2), var55);
               }

               Client.packetOpcode = -1;
               return true;
            }

            Widget var101;
            if(Client.packetOpcode == 210) {
               var1 = Client.field347.method2715();
               var101 = class173.method3412(var1);
               var101.modelType = 3;
               var101.modelId = class138.localPlayer.composition.method3516();
               class32.method673(var101);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 242) {
               Tile.field1797 = Client.field347.method2544();
               ItemComposition.field1214 = Client.field347.method2571();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 172) {
               GroundObject.xteaChanged(false);
               Client.field347.method2788();
               var1 = Client.field347.method2546();
               class24.method576(Client.field347, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 209) {
               class48.method996();
               Client.weight = Client.field347.method2547();
               Client.field497 = Client.field485;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 93) {
               var1 = Client.field347.method2715();
               class10.field181 = class40.field898.method2940(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 115) {
               Tile.field1797 = Client.field347.method2653();
               ItemComposition.field1214 = Client.field347.method2653();

               for(var1 = ItemComposition.field1214; var1 < 8 + ItemComposition.field1214; ++var1) {
                  for(var2 = Tile.field1797; var2 < 8 + Tile.field1797; ++var2) {
                     if(null != Client.groundItemDeque[class173.plane][var1][var2]) {
                        Client.groundItemDeque[class173.plane][var1][var2] = null;
                        class174.groundItemSpawned(var1, var2);
                     }
                  }
               }

               for(class16 var85 = (class16)Client.field571.method3845(); var85 != null; var85 = (class16)Client.field571.method3847()) {
                  if(var85.field243 >= ItemComposition.field1214 && var85.field243 < 8 + ItemComposition.field1214 && var85.field260 >= Tile.field1797 && var85.field260 < Tile.field1797 + 8 && var85.field252 == class173.plane) {
                     var85.field242 = 0;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 100) {
               Client.field518 = Client.field347.method2544();
               Client.field519 = Client.field347.method2544();
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 20) {
               var1 = Client.field347.method2589();
               var2 = Client.field347.method2572();
               var77 = class173.method3412(var1);
               if(var77.modelType != 2 || var77.modelId != var2) {
                  var77.modelType = 2;
                  var77.modelId = var2;
                  class32.method673(var77);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 220) {
               class23.method564(Client.field347.method2552());
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 201) {
               var21 = Client.field347.method2552();
               var2 = Client.field347.method2653();
               var3 = Client.field347.method2571();
               if(var2 >= 1 && var2 <= 8) {
                  if(var21.equalsIgnoreCase("null")) {
                     var21 = null;
                  }

                  Client.field429[var2 - 1] = var21;
                  Client.field430[var2 - 1] = var3 == 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 234) {
               var1 = Client.field347.method2582();
               var2 = Client.field347.method2589();
               var77 = class173.method3412(var2);
               if(var1 != var77.field2828 || var1 == -1) {
                  var77.field2828 = var1;
                  var77.field2934 = 0;
                  var77.field2925 = 0;
                  class32.method673(var77);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 198) {
               if(Client.widgetRoot != -1) {
                  var1 = Client.widgetRoot;
                  if(class14.method172(var1)) {
                     class49.method1007(Widget.widgets[var1], 0);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 30) {
               class48.method996();
               Client.energy = Client.field347.method2544();
               Client.field497 = Client.field485;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 123) {
               Client.flagX = Client.field347.method2544();
               if(Client.flagX == 255) {
                  Client.flagX = 0;
               }

               Client.flagY = Client.field347.method2544();
               if(Client.flagY == 255) {
                  Client.flagY = 0;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 189) {
               var21 = Client.field347.method2552();
               Object[] var104 = new Object[var21.length() + 1];

               for(var3 = var21.length() - 1; var3 >= 0; --var3) {
                  if(var21.charAt(var3) == 115) {
                     var104[var3 + 1] = Client.field347.method2552();
                  } else {
                     var104[1 + var3] = new Integer(Client.field347.method2549());
                  }
               }

               var104[0] = new Integer(Client.field347.method2549());
               class0 var96 = new class0();
               var96.field8 = var104;
               class12.method155(var96);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 166) {
               var1 = Client.field347.method2725();
               var2 = Client.field347.method2590();
               var77 = class173.method3412(var2);
               if(var77.modelType != 1 || var77.modelId != var1) {
                  var77.modelType = 1;
                  var77.modelId = var1;
                  class32.method673(var77);
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var50;
            if(Client.packetOpcode == 248) {
               var1 = Client.field347.method2573();
               var63 = Client.field347.method2544() == 1;
               var75 = "";
               var50 = false;
               if(var63) {
                  var75 = Client.field347.method2552();
                  if(class128.method2839(var75)) {
                     var50 = true;
                  }
               }

               String var95 = Client.field347.method2552();
               if(!var50) {
                  class110.method2416(var1, var75, var95);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 66) {
               var1 = Client.field347.method2589();
               var2 = Client.field347.method2725();
               var3 = Client.field347.method2546();
               var4 = Client.field347.method2528();
               var94 = class173.method3412(var1);
               if(var4 != var94.rotationX || var3 != var94.rotationZ || var2 != var94.field2856) {
                  var94.rotationX = var4;
                  var94.rotationZ = var3;
                  var94.field2856 = var2;
                  class32.method673(var94);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 140) {
               var1 = Client.field347.method2715();
               var101 = class173.method3412(var1);

               for(var3 = 0; var3 < var101.itemIds.length; ++var3) {
                  var101.itemIds[var3] = -1;
                  var101.itemIds[var3] = 0;
               }

               class32.method673(var101);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 104) {
               var1 = Client.field347.method2572();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               var2 = Client.field347.method2590();
               var3 = Client.field347.method2590();
               var23 = class173.method3412(var2);
               ItemComposition var92;
               if(!var23.field2862) {
                  if(var1 == -1) {
                     var23.modelType = 0;
                     Client.packetOpcode = -1;
                     return true;
                  }

                  var92 = class92.getItemDefinition(var1);
                  var23.modelType = 4;
                  var23.modelId = var1;
                  var23.rotationX = var92.field1178;
                  var23.rotationZ = var92.field1179;
                  var23.field2856 = var92.field1177 * 100 / var3;
                  class32.method673(var23);
               } else {
                  var23.item = var1;
                  var23.stackSize = var3;
                  var92 = class92.getItemDefinition(var1);
                  var23.rotationX = var92.field1178;
                  var23.rotationZ = var92.field1179;
                  var23.rotationY = var92.field1180;
                  var23.field2913 = var92.field1181;
                  var23.field2898 = var92.field1182;
                  var23.field2856 = var92.field1177;
                  if(var92.isStackable == 1) {
                     var23.field2860 = 1;
                  } else {
                     var23.field2860 = 2;
                  }

                  if(var23.field2791 > 0) {
                     var23.field2856 = var23.field2856 * 32 / var23.field2791;
                  } else if(var23.field2813 > 0) {
                     var23.field2856 = var23.field2856 * 32 / var23.field2813;
                  }

                  class32.method673(var23);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 219) {
               var1 = Client.field347.method2572();
               var2 = Client.field347.method2715();
               var3 = var1 >> 10 & 31;
               var4 = var1 >> 5 & 31;
               var5 = var1 & 31;
               var6 = (var3 << 19) + (var4 << 11) + (var5 << 3);
               Widget var111 = class173.method3412(var2);
               if(var111.textColor != var6) {
                  var111.textColor = var6;
                  class32.method673(var111);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 251) {
               class24.method576(Client.field347, Client.field348);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 247) {
               var1 = Client.field347.method2725();
               XItemContainer var98 = (XItemContainer)XItemContainer.itemContainers.method3812((long)var1);
               if(null != var98) {
                  var98.unlink();
               }

               Client.field488[++Client.field489 - 1 & 31] = var1 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 81) {
               var1 = Client.field347.method2546();
               Client.widgetRoot = var1;
               BufferProvider.method1732(false);
               class24.method567(var1);
               class10.method133(Client.widgetRoot);

               for(var2 = 0; var2 < 100; ++var2) {
                  Client.field494[var2] = true;
               }

               Client.packetOpcode = -1;
               return true;
            }

            boolean var8;
            long var56;
            long var66;
            int var115;
            if(Client.packetOpcode == 70) {
               Client.field570 = Client.field485;
               if(Client.field348 == 0) {
                  Client.field541 = null;
                  Client.field528 = null;
                  class40.field896 = 0;
                  class146.clanMembers = null;
                  Client.packetOpcode = -1;
                  return true;
               }

               Client.field528 = Client.field347.method2552();
               long var59 = Client.field347.method2566();
               var56 = var59;
               if(var59 > 0L && var59 < 6582952005840035281L) {
                  if(0L == var59 % 37L) {
                     var75 = null;
                  } else {
                     var6 = 0;

                     for(long var60 = var59; var60 != 0L; var60 /= 37L) {
                        ++var6;
                     }

                     StringBuilder var62 = new StringBuilder(var6);

                     while(var56 != 0L) {
                        var66 = var56;
                        var56 /= 37L;
                        var62.append(class165.field2698[(int)(var66 - 37L * var56)]);
                     }

                     var75 = var62.reverse().toString();
                  }
               } else {
                  var75 = null;
               }

               Client.field541 = var75;
               class14.field224 = Client.field347.method2545();
               var6 = Client.field347.method2544();
               if(var6 == 255) {
                  Client.packetOpcode = -1;
                  return true;
               }

               class40.field896 = var6;
               XClanMember[] var107 = new XClanMember[100];

               for(var58 = 0; var58 < class40.field896; ++var58) {
                  var107[var58] = new XClanMember();
                  var107[var58].username = Client.field347.method2552();
                  var107[var58].field651 = class93.method2141(var107[var58].username, Client.field302);
                  var107[var58].world = Client.field347.method2546();
                  var107[var58].rank = Client.field347.method2545();
                  Client.field347.method2552();
                  if(var107[var58].username.equals(class138.localPlayer.name)) {
                     Item.field713 = var107[var58].rank;
                  }
               }

               var8 = false;
               var67 = class40.field896;

               while(var67 > 0) {
                  var8 = true;
                  --var67;

                  for(var115 = 0; var115 < var67; ++var115) {
                     if(var107[var115].field651.compareTo(var107[1 + var115].field651) > 0) {
                        XClanMember var64 = var107[var115];
                        var107[var115] = var107[1 + var115];
                        var107[var115 + 1] = var64;
                        var8 = false;
                     }
                  }

                  if(var8) {
                     break;
                  }
               }

               class146.clanMembers = var107;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 16) {
               var1 = Client.field347.method2571();
               var2 = Client.field347.method2546();
               var3 = Client.field347.method2590();
               var82 = (WidgetNode)Client.componentTable.method3812((long)var3);
               if(var82 != null) {
                  class187.method3741(var82, var82.id != var2);
               }

               class51.method1073(var3, var2, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 236) {
               Client.field569 = 1;
               Client.field493 = Client.field485;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 35) {
               Client.field548 = true;
               class117.field2018 = Client.field347.method2544();
               BufferProvider.field1445 = Client.field347.method2544();
               class93.field1617 = Client.field347.method2546();
               class20.field589 = Client.field347.method2544();
               class156.field2330 = Client.field347.method2544();
               if(class156.field2330 >= 100) {
                  ChatLineBuffer.cameraX = 64 + class117.field2018 * 128;
                  class35.cameraY = 64 + BufferProvider.field1445 * 128;
                  class28.cameraZ = class16.method191(ChatLineBuffer.cameraX, class35.cameraY, class173.plane) - class93.field1617;
               }

               Client.packetOpcode = -1;
               return true;
            }

            long var57;
            if(Client.packetOpcode == 87) {
               var1 = Client.field347.method2549();
               var2 = Client.field347.method2549();
               if(Frames.field1830 == null || !Frames.field1830.isValid()) {
                  try {
                     Iterator var80 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

                     while(var80.hasNext()) {
                        GarbageCollectorMXBean var89 = (GarbageCollectorMXBean)var80.next();
                        if(var89.isValid()) {
                           Frames.field1830 = var89;
                           Client.field450 = -1L;
                           Client.field578 = -1L;
                        }
                     }
                  } catch (Throwable var40) {
                     ;
                  }
               }

               long var52 = class34.method738();
               var5 = -1;
               if(Frames.field1830 != null) {
                  var55 = Frames.field1830.getCollectionTime();
                  if(-1L != Client.field578) {
                     var57 = var55 - Client.field578;
                     var66 = var52 - Client.field450;
                     if(0L != var66) {
                        var5 = (int)(var57 * 100L / var66);
                     }
                  }

                  Client.field578 = var55;
                  Client.field450 = var52;
               }

               Client.field378.method2801(145);
               Client.field378.method2568(var5);
               Client.field378.method2569(GameEngine.field2248);
               Client.field378.method2610(var1);
               Client.field378.method2731(var2);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 151) {
               var1 = Client.field347.method2549();
               var2 = Client.field347.method2546();
               if(var1 < -70000) {
                  var2 += '耀';
               }

               if(var1 >= 0) {
                  var77 = class173.method3412(var1);
               } else {
                  var77 = null;
               }

               if(var77 != null) {
                  for(var4 = 0; var4 < var77.itemIds.length; ++var4) {
                     var77.itemIds[var4] = 0;
                     var77.itemQuantities[var4] = 0;
                  }
               }

               XItemContainer var86 = (XItemContainer)XItemContainer.itemContainers.method3812((long)var2);
               if(null != var86) {
                  for(var5 = 0; var5 < var86.itemIds.length; ++var5) {
                     var86.itemIds[var5] = -1;
                     var86.stackSizes[var5] = 0;
                  }
               }

               var4 = Client.field347.method2546();

               for(var5 = 0; var5 < var4; ++var5) {
                  var6 = Client.field347.method2544();
                  if(var6 == 255) {
                     var6 = Client.field347.method2715();
                  }

                  var54 = Client.field347.method2572();
                  if(null != var77 && var5 < var77.itemIds.length) {
                     var77.itemIds[var5] = var54;
                     var77.itemQuantities[var5] = var6;
                  }

                  class18.method200(var2, var5, var54 - 1, var6);
               }

               if(var77 != null) {
                  class32.method673(var77);
               }

               class48.method996();
               Client.field488[++Client.field489 - 1 & 31] = var2 & 32767;
               Client.packetOpcode = -1;
               return true;
            }

            long var51;
            if(Client.packetOpcode == 162) {
               var21 = Client.field347.method2552();
               var51 = Client.field347.method2566();
               var56 = (long)Client.field347.method2546();
               var55 = (long)Client.field347.method2548();
               class155[] var31 = new class155[]{class155.field2314, class155.field2311, class155.field2312, class155.field2310, class155.field2309, class155.field2319};
               class155 var61 = (class155)class140.method2957(var31, Client.field347.method2544());
               var66 = var55 + (var56 << 32);
               boolean var12 = false;

               for(var13 = 0; var13 < 100; ++var13) {
                  if(var66 == Client.field521[var13]) {
                     var12 = true;
                     break;
                  }
               }

               if(var61.field2320 && class128.method2839(var21)) {
                  var12 = true;
               }

               if(!var12 && Client.field442 == 0) {
                  Client.field521[Client.field468] = var66;
                  Client.field468 = (1 + Client.field468) % 100;
                  class125 var14 = Client.field347;

                  String var70;
                  try {
                     var16 = var14.method2573();
                     if(var16 > 32767) {
                        var16 = 32767;
                     }

                     byte[] var17 = new byte[var16];
                     var14.offset += class225.field3236.method2479(var14.payload, var14.offset, var17, 0, var16);
                     String var18 = RSCanvas.method2975(var17, 0, var16);
                     var70 = var18;
                  } catch (Exception var39) {
                     var70 = "Cabbage";
                  }

                  var70 = class226.method4066(class129.method2849(var70));
                  if(var61.field2317 != -1) {
                     ChatLineBuffer.addChatMessage(9, class109.method2411(var61.field2317) + var21, var70, ItemLayer.method2244(var51));
                  } else {
                     ChatLineBuffer.addChatMessage(9, var21, var70, ItemLayer.method2244(var51));
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 159) {
               var48 = Client.field347.method2544() == 1;
               if(var48) {
                  class38.field831 = class34.method738() - Client.field347.method2566();
                  class136.field2122 = new class224(Client.field347, true);
               } else {
                  class136.field2122 = null;
               }

               Client.field496 = Client.field485;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 129) {
               var2 = Client.field347.method2544();
               class133[] var78 = class1.method9();
               var4 = 0;

               class133 var76;
               while(true) {
                  if(var4 >= var78.length) {
                     var76 = null;
                     break;
                  }

                  class133 var90 = var78[var4];
                  if(var2 == var90.field2112) {
                     var76 = var90;
                     break;
                  }

                  ++var4;
               }

               class173.field2754 = var76;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 88) {
               var1 = Client.field347.offset + Client.field348;
               var2 = Client.field347.method2546();
               var3 = Client.field347.method2546();
               if(var2 != Client.widgetRoot) {
                  Client.widgetRoot = var2;
                  BufferProvider.method1732(false);
                  class24.method567(Client.widgetRoot);
                  class10.method133(Client.widgetRoot);

                  for(var4 = 0; var4 < 100; ++var4) {
                     Client.field494[var4] = true;
                  }
               }

               WidgetNode var102;
               for(; var3-- > 0; var102.field67 = true) {
                  var4 = Client.field347.method2549();
                  var5 = Client.field347.method2546();
                  var6 = Client.field347.method2544();
                  var102 = (WidgetNode)Client.componentTable.method3812((long)var4);
                  if(var102 != null && var5 != var102.id) {
                     class187.method3741(var102, true);
                     var102 = null;
                  }

                  if(var102 == null) {
                     var102 = class51.method1073(var4, var5, var6);
                  }
               }

               for(var82 = (WidgetNode)Client.componentTable.method3815(); var82 != null; var82 = (WidgetNode)Client.componentTable.method3816()) {
                  if(var82.field67) {
                     var82.field67 = false;
                  } else {
                     class187.method3741(var82, true);
                  }
               }

               Client.widgetFlags = new XHashTable(512);

               while(Client.field347.offset < var1) {
                  var4 = Client.field347.method2549();
                  var5 = Client.field347.method2546();
                  var6 = Client.field347.method2546();
                  var54 = Client.field347.method2549();

                  for(var58 = var5; var58 <= var6; ++var58) {
                     long var116 = ((long)var4 << 32) + (long)var58;
                     Client.widgetFlags.method3813(new class204(var54), var116);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 27) {
               CollisionData.method2456(false);
               Client.packetOpcode = -1;
               return true;
            }

            String var26;
            if(Client.packetOpcode == 239) {
               var1 = Client.field347.method2590();
               var26 = Client.field347.method2552();
               var77 = class173.method3412(var1);
               if(!var26.equals(var77.text)) {
                  var77.text = var26;
                  class32.method673(var77);
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 57) {
               for(var1 = 0; var1 < class179.widgetSettings.length; ++var1) {
                  if(class179.widgetSettings[var1] != class179.settings[var1]) {
                     class179.widgetSettings[var1] = class179.settings[var1];
                     RSCanvas.method2982(var1);
                     Client.field486[++Client.field426 - 1 & 31] = var1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 117) {
               ItemComposition.field1214 = Client.field347.method2653();
               Tile.field1797 = Client.field347.method2544();

               while(Client.field347.offset < Client.field348) {
                  Client.packetOpcode = Client.field347.method2544();
                  class5.method70();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 101) {
               var21 = Client.field347.method2552();
               var2 = Client.field347.method2546();
               byte var49 = Client.field347.method2545();
               var50 = false;
               if(var49 == -128) {
                  var50 = true;
               }

               if(var50) {
                  if(class40.field896 == 0) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  boolean var53 = false;

                  for(var5 = 0; var5 < class40.field896 && (!class146.clanMembers[var5].username.equals(var21) || var2 != class146.clanMembers[var5].world); ++var5) {
                     ;
                  }

                  if(var5 < class40.field896) {
                     while(var5 < class40.field896 - 1) {
                        class146.clanMembers[var5] = class146.clanMembers[var5 + 1];
                        ++var5;
                     }

                     --class40.field896;
                     class146.clanMembers[class40.field896] = null;
                  }
               } else {
                  Client.field347.method2552();
                  XClanMember var87 = new XClanMember();
                  var87.username = var21;
                  var87.field651 = class93.method2141(var87.username, Client.field302);
                  var87.world = var2;
                  var87.rank = var49;

                  for(var6 = class40.field896 - 1; var6 >= 0; --var6) {
                     var54 = class146.clanMembers[var6].field651.compareTo(var87.field651);
                     if(var54 == 0) {
                        class146.clanMembers[var6].world = var2;
                        class146.clanMembers[var6].rank = var49;
                        if(var21.equals(class138.localPlayer.name)) {
                           Item.field713 = var49;
                        }

                        Client.field570 = Client.field485;
                        Client.packetOpcode = -1;
                        return true;
                     }

                     if(var54 < 0) {
                        break;
                     }
                  }

                  if(class40.field896 >= class146.clanMembers.length) {
                     Client.packetOpcode = -1;
                     return true;
                  }

                  for(var54 = class40.field896 - 1; var54 > var6; --var54) {
                     class146.clanMembers[1 + var54] = class146.clanMembers[var54];
                  }

                  if(class40.field896 == 0) {
                     class146.clanMembers = new XClanMember[100];
                  }

                  class146.clanMembers[var6 + 1] = var87;
                  ++class40.field896;
                  if(var21.equals(class138.localPlayer.name)) {
                     Item.field713 = var49;
                  }
               }

               Client.field570 = Client.field485;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 86) {
               var21 = Client.field347.method2552();
               var51 = (long)Client.field347.method2546();
               var56 = (long)Client.field347.method2548();
               class155[] var83 = new class155[]{class155.field2314, class155.field2311, class155.field2312, class155.field2310, class155.field2309, class155.field2319};
               class155 var99 = (class155)class140.method2957(var83, Client.field347.method2544());
               var57 = (var51 << 32) + var56;
               boolean var10 = false;

               for(var115 = 0; var115 < 100; ++var115) {
                  if(Client.field521[var115] == var57) {
                     var10 = true;
                     break;
                  }
               }

               if(class128.method2839(var21)) {
                  var10 = true;
               }

               if(!var10 && Client.field442 == 0) {
                  Client.field521[Client.field468] = var57;
                  Client.field468 = (Client.field468 + 1) % 100;
                  class125 var108 = Client.field347;

                  String var30;
                  try {
                     int var35 = var108.method2573();
                     if(var35 > 32767) {
                        var35 = 32767;
                     }

                     byte[] var15 = new byte[var35];
                     var108.offset += class225.field3236.method2479(var108.payload, var108.offset, var15, 0, var35);
                     String var33 = RSCanvas.method2975(var15, 0, var35);
                     var30 = var33;
                  } catch (Exception var38) {
                     var30 = "Cabbage";
                  }

                  var30 = class226.method4066(class129.method2849(var30));
                  byte var117;
                  if(var99.field2315) {
                     var117 = 7;
                  } else {
                     var117 = 3;
                  }

                  if(var99.field2317 != -1) {
                     class110.method2416(var117, class109.method2411(var99.field2317) + var21, var30);
                  } else {
                     class110.method2416(var117, var21, var30);
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 71) {
               for(var1 = 0; var1 < Client.cachedPlayers.length; ++var1) {
                  if(null != Client.cachedPlayers[var1]) {
                     Client.cachedPlayers[var1].animation = -1;
                  }
               }

               for(var1 = 0; var1 < Client.cachedNPCs.length; ++var1) {
                  if(null != Client.cachedNPCs[var1]) {
                     Client.cachedNPCs[var1].animation = -1;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 7) {
               Client.field548 = false;

               for(var1 = 0; var1 < 5; ++var1) {
                  Client.field520[var1] = false;
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 116) {
               Client.field306 = Client.field347.method2544();
               if(Client.field306 == 1) {
                  Client.field319 = Client.field347.method2546();
               }

               if(Client.field306 >= 2 && Client.field306 <= 6) {
                  if(Client.field306 == 2) {
                     Client.field540 = 64;
                     Client.field325 = 64;
                  }

                  if(Client.field306 == 3) {
                     Client.field540 = 0;
                     Client.field325 = 64;
                  }

                  if(Client.field306 == 4) {
                     Client.field540 = 128;
                     Client.field325 = 64;
                  }

                  if(Client.field306 == 5) {
                     Client.field540 = 64;
                     Client.field325 = 0;
                  }

                  if(Client.field306 == 6) {
                     Client.field540 = 64;
                     Client.field325 = 128;
                  }

                  Client.field306 = 2;
                  Client.field321 = Client.field347.method2546();
                  Client.field529 = Client.field347.method2546();
                  Client.field323 = Client.field347.method2544();
               }

               if(Client.field306 == 10) {
                  Client.field320 = Client.field347.method2546();
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 232) {
               var1 = Client.field347.method2544();
               var2 = Client.field347.method2544();
               var3 = Client.field347.method2544();
               var4 = Client.field347.method2544();
               Client.field520[var1] = true;
               Client.field551[var1] = var2;
               Client.field552[var1] = var3;
               Client.field553[var1] = var4;
               Client.field504[var1] = 0;
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 54) {
               var1 = Client.field347.method2528();
               if(var1 == '\uffff') {
                  var1 = -1;
               }

               class114.method2462(var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 69) {
               var1 = Client.field347.method2548();
               var2 = Client.field347.method2546();
               if(var2 == '\uffff') {
                  var2 = -1;
               }

               XItemContainer.method182(var2, var1);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 111) {
               while(Client.field347.offset < Client.field348) {
                  var48 = Client.field347.method2544() == 1;
                  var26 = Client.field347.method2552();
                  var75 = Client.field347.method2552();
                  var4 = Client.field347.method2546();
                  var5 = Client.field347.method2544();
                  var6 = Client.field347.method2544();
                  boolean var7 = (var6 & 2) != 0;
                  var8 = (var6 & 1) != 0;
                  if(var4 > 0) {
                     Client.field347.method2552();
                     Client.field347.method2544();
                     Client.field347.method2549();
                  }

                  Client.field347.method2552();

                  for(int var34 = 0; var34 < Client.friendCount; ++var34) {
                     Friend var28 = Client.friends[var34];
                     if(!var48) {
                        if(var26.equals(var28.name)) {
                           if(var4 != var28.world) {
                              boolean var32 = true;

                              for(class40 var29 = (class40)Client.field503.method3804(); null != var29; var29 = (class40)Client.field503.method3810()) {
                                 if(var29.field901.equals(var26)) {
                                    if(var4 != 0 && var29.field903 == 0) {
                                       var29.method3944();
                                       var32 = false;
                                    } else if(var4 == 0 && var29.field903 != 0) {
                                       var29.method3944();
                                       var32 = false;
                                    }
                                 }
                              }

                              if(var32) {
                                 Client.field503.method3803(new class40(var26, var4));
                              }

                              var28.world = var4;
                           }

                           var28.previousName = var75;
                           var28.rank = var5;
                           var28.field271 = var7;
                           var28.field266 = var8;
                           var26 = null;
                           break;
                        }
                     } else if(var75.equals(var28.name)) {
                        var28.name = var26;
                        var28.previousName = var75;
                        var26 = null;
                        break;
                     }
                  }

                  if(null != var26 && Client.friendCount < 400) {
                     Friend var9 = new Friend();
                     Client.friends[Client.friendCount] = var9;
                     var9.name = var26;
                     var9.previousName = var75;
                     var9.world = var4;
                     var9.rank = var5;
                     var9.field271 = var7;
                     var9.field266 = var8;
                     ++Client.friendCount;
                  }
               }

               Client.field569 = 2;
               Client.field493 = Client.field485;
               var48 = false;
               var2 = Client.friendCount;

               while(var2 > 0) {
                  var48 = true;
                  --var2;

                  for(var3 = 0; var3 < var2; ++var3) {
                     var50 = false;
                     Friend var25 = Client.friends[var3];
                     Friend var81 = Client.friends[1 + var3];
                     if(Client.world != var25.world && var81.world == Client.world) {
                        var50 = true;
                     }

                     if(!var50 && var25.world == 0 && var81.world != 0) {
                        var50 = true;
                     }

                     if(!var50 && !var25.field271 && var81.field271) {
                        var50 = true;
                     }

                     if(!var50 && !var25.field266 && var81.field266) {
                        var50 = true;
                     }

                     if(var50) {
                        Friend var97 = Client.friends[var3];
                        Client.friends[var3] = Client.friends[var3 + 1];
                        Client.friends[var3 + 1] = var97;
                        var48 = false;
                     }
                  }

                  if(var48) {
                     break;
                  }
               }

               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 118) {
               var21 = Client.field347.method2552();
               class125 var22 = Client.field347;

               try {
                  var5 = var22.method2573();
                  if(var5 > 32767) {
                     var5 = 32767;
                  }

                  byte[] var24 = new byte[var5];
                  var22.offset += class225.field3236.method2479(var22.payload, var22.offset, var24, 0, var5);
                  var27 = RSCanvas.method2975(var24, 0, var5);
                  var79 = var27;
               } catch (Exception var37) {
                  var79 = "Cabbage";
               }

               var79 = class226.method4066(class129.method2849(var79));
               class110.method2416(6, var21, var79);
               Client.packetOpcode = -1;
               return true;
            }

            if(Client.packetOpcode == 60) {
               var1 = Client.field347.method2715();
               var2 = Client.field347.method2725();
               var3 = Client.field347.method2725();
               var23 = class173.method3412(var1);
               var23.field2858 = (var2 << 16) + var3;
               Client.packetOpcode = -1;
               return true;
            }

            class93.method2139("" + Client.packetOpcode + "," + Client.field421 + "," + Client.field354 + "," + Client.field348, (Throwable)null);
            Sequence.method902();
         } catch (IOException var46) {
            if(Client.field355 > 0) {
               Sequence.method902();
            } else {
               class117.setGameState(40);
               class59.field1250 = ObjectComposition.field993;
               ObjectComposition.field993 = null;
            }
         } catch (Exception var47) {
            var21 = "" + Client.packetOpcode + "," + Client.field421 + "," + Client.field354 + "," + Client.field348 + "," + (class138.localPlayer.pathX[0] + class193.baseX) + "," + (DecorativeObject.baseY + class138.localPlayer.pathY[0]) + ",";

            for(var2 = 0; var2 < Client.field348 && var2 < 50; ++var2) {
               var21 = var21 + Client.field347.payload[var2] + ",";
            }

            class93.method2139(var21, var47);
            Sequence.method902();
         }

         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;Lclass170;Lclass187;I)Z",
      garbageValue = "809200597"
   )
   public static boolean method3399(class170 var0, class170 var1, class170 var2, class187 var3) {
      class186.field3011 = var0;
      class186.field3014 = var1;
      class186.field3012 = var2;
      class186.field3013 = var3;
      return true;
   }

   public class171(class137 var1, class137 var2, int var3, boolean var4, boolean var5, boolean var6) {
      super(var4, var5);
      this.field2739 = var1;
      this.field2744 = var2;
      this.field2736 = var3;
      this.field2738 = var6;
      int var8 = this.field2736;
      if(null != ChatLineBuffer.field706) {
         ChatLineBuffer.field706.offset = 8 * var8 + 5;
         int var9 = ChatLineBuffer.field706.method2549();
         int var10 = ChatLineBuffer.field706.method2549();
         this.method3371(var9, var10);
      } else {
         MessageNode.method764((class171)null, 255, 255, 0, (byte)0, true);
         class174.field2775[var8] = this;
      }

   }
}
