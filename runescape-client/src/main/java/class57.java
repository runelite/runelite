import java.awt.Component;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bi")
public class class57 {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -7965052317868388777L
   )
   long field1028;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -570699994732564715L
   )
   long field1029;
   @ObfuscatedName("p")
   static class59 field1030;
   @ObfuscatedName("l")
   int[] field1031;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1780135083
   )
   public static int field1032;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1489086505
   )
   int field1033;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -8109436352898789245L
   )
   long field1034;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -913283765
   )
   int field1035;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1873848849
   )
   int field1036;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1345084219
   )
   int field1037;
   @ObfuscatedName("ax")
   class68[] field1038;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -210158377
   )
   int field1039;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1343011991
   )
   int field1040;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2087858389
   )
   int field1041;
   @ObfuscatedName("v")
   class68 field1042;
   @ObfuscatedName("h")
   boolean field1043;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -178157749
   )
   int field1045;
   @ObfuscatedName("ac")
   class68[] field1046;
   @ObfuscatedName("c")
   public static boolean field1047;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass68;B)V",
      garbageValue = "-100"
   )
   public final synchronized void method1065(class68 var1) {
      this.field1042 = var1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2104764341"
   )
   public final void method1067() {
      this.field1043 = true;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-442757286"
   )
   public final synchronized void method1069() {
      if(field1030 != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if(field1030.field1061[var2] == this) {
               field1030.field1061[var2] = null;
            }

            if(field1030.field1061[var2] != null) {
               var1 = false;
            }
         }

         if(var1) {
            class219.field3197.shutdownNow();
            class219.field3197 = null;
            field1030 = null;
         }
      }

      this.vmethod1147();
      this.field1031 = null;
   }

   class57() {
      this.field1033 = 32;
      this.field1029 = class72.method1421();
      this.field1034 = 0L;
      this.field1039 = 0;
      this.field1040 = 0;
      this.field1041 = 0;
      this.field1028 = 0L;
      this.field1043 = true;
      this.field1045 = 0;
      this.field1038 = new class68[8];
      this.field1046 = new class68[8];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass68;II)V",
      garbageValue = "1954400318"
   )
   final void method1071(class68 var1, int var2) {
      int var3 = var2 >> 5;
      class68 var4 = this.field1046[var3];
      if(var4 == null) {
         this.field1038[var3] = var1;
      } else {
         var4.field1124 = var1;
      }

      this.field1046[var3] = var1;
      var1.field1123 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/awt/Component;B)V",
      garbageValue = "-35"
   )
   void vmethod1143(Component var1) throws Exception {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "256"
   )
   final void method1073(int[] var1, int var2) {
      int var3 = var2;
      if(field1047) {
         var3 = var2 << 1;
      }

      class139.method2677(var1, 0, var3);
      this.field1045 -= var2;
      if(this.field1042 != null && this.field1045 <= 0) {
         this.field1045 += field1032 >> 4;
         class166.method3132(this.field1042);
         this.method1071(this.field1042, this.field1042.vmethod1361());
         int var4 = 0;
         int var5 = 255;

         int var6;
         class68 var10;
         label139:
         for(var6 = 7; var5 != 0; --var6) {
            int var16;
            int var17;
            if(var6 < 0) {
               var16 = var6 & 3;
               var17 = -(var6 >> 2);
            } else {
               var16 = var6;
               var17 = 0;
            }

            for(int var9 = var5 >>> var16 & 286331153; var9 != 0; var9 >>>= 4) {
               if((var9 & 1) != 0) {
                  var5 &= ~(1 << var16);
                  var10 = null;
                  class68 var11 = this.field1038[var16];

                  label133:
                  while(true) {
                     while(true) {
                        if(var11 == null) {
                           break label133;
                        }

                        class71 var12 = var11.field1122;
                        if(var12 != null && var12.field1156 > var17) {
                           var5 |= 1 << var16;
                           var10 = var11;
                           var11 = var11.field1124;
                        } else {
                           var11.field1125 = true;
                           int var13 = var11.vmethod3097();
                           var4 += var13;
                           if(var12 != null) {
                              var12.field1156 += var13;
                           }

                           if(var4 >= this.field1033) {
                              break label139;
                           }

                           class68 var14 = var11.vmethod3102();
                           if(var14 != null) {
                              for(int var15 = var11.field1123; var14 != null; var14 = var11.vmethod3091()) {
                                 this.method1071(var14, var15 * var14.vmethod1361() >> 8);
                              }
                           }

                           class68 var18 = var11.field1124;
                           var11.field1124 = null;
                           if(var10 == null) {
                              this.field1038[var16] = var18;
                           } else {
                              var10.field1124 = var18;
                           }

                           if(var18 == null) {
                              this.field1046[var16] = var10;
                           }

                           var11 = var18;
                        }
                     }
                  }
               }

               var16 += 4;
               ++var17;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            class68 var7 = this.field1038[var6];
            class68[] var8 = this.field1038;
            this.field1046[var6] = null;

            for(var8[var6] = null; var7 != null; var7 = var10) {
               var10 = var7.field1124;
               var7.field1124 = null;
            }
         }
      }

      if(this.field1045 < 0) {
         this.field1045 = 0;
      }

      if(this.field1042 != null) {
         this.field1042.vmethod3093(var1, 0, var2);
      }

      this.field1029 = class72.method1421();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-87"
   )
   int vmethod1145() throws Exception {
      return this.field1035;
   }

   @ObfuscatedName("i")
   void vmethod1142() throws Exception {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "52"
   )
   void vmethod1147() {
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1843028020"
   )
   void vmethod1154() throws Exception {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1603720189"
   )
   public final synchronized void method1078() {
      if(this.field1031 != null) {
         long var1 = class72.method1421();

         try {
            if(0L != this.field1034) {
               if(var1 < this.field1034) {
                  return;
               }

               this.vmethod1144(this.field1035);
               this.field1034 = 0L;
               this.field1043 = true;
            }

            int var3 = this.vmethod1145();
            if(this.field1041 - var3 > this.field1039) {
               this.field1039 = this.field1041 - var3;
            }

            int var4 = this.field1036 + this.field1037;
            if(var4 + 256 > 16384) {
               var4 = 16128;
            }

            if(var4 + 256 > this.field1035) {
               this.field1035 += 1024;
               if(this.field1035 > 16384) {
                  this.field1035 = 16384;
               }

               this.vmethod1147();
               this.vmethod1144(this.field1035);
               var3 = 0;
               this.field1043 = true;
               if(var4 + 256 > this.field1035) {
                  var4 = this.field1035 - 256;
                  this.field1037 = var4 - this.field1036;
               }
            }

            while(var3 < var4) {
               this.method1073(this.field1031, 256);
               this.vmethod1142();
               var3 += 256;
            }

            if(var1 > this.field1028) {
               if(!this.field1043) {
                  if(this.field1039 == 0 && this.field1040 == 0) {
                     this.vmethod1147();
                     this.field1034 = var1 + 2000L;
                     return;
                  }

                  this.field1037 = Math.min(this.field1040, this.field1039);
                  this.field1040 = this.field1039;
               } else {
                  this.field1043 = false;
               }

               this.field1039 = 0;
               this.field1028 = 2000L + var1;
            }

            this.field1041 = var3;
         } catch (Exception var7) {
            this.vmethod1147();
            this.field1034 = var1 + 2000L;
         }

         try {
            if(var1 > 500000L + this.field1029) {
               var1 = this.field1029;
            }

            while(var1 > 5000L + this.field1029) {
               this.method1117(256);
               this.field1029 += (long)(256000 / field1032);
            }
         } catch (Exception var6) {
            this.field1029 = var1;
         }

      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "132446347"
   )
   static int method1082(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class128.method2364(class32.intStack[--class32.intStackSize]);
      } else {
         var3 = var2?class200.field2894:Script.field942;
      }

      String var4 = class32.scriptStringStack[--class32.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var8 = class32.intStack[--class32.intStackSize];
         if(var8 > 0) {
            for(var5 = new int[var8]; var8-- > 0; var5[var8] = class32.intStack[--class32.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var6 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var6.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var6[var7] = class32.scriptStringStack[--class32.scriptStringStackSize];
         } else {
            var6[var7] = new Integer(class32.intStack[--class32.intStackSize]);
         }
      }

      var7 = class32.intStack[--class32.intStackSize];
      if(var7 != -1) {
         var6[0] = new Integer(var7);
      } else {
         var6 = null;
      }

      if(var0 == 1400) {
         var3.field2289 = var6;
      } else if(var0 == 1401) {
         var3.field2292 = var6;
      } else if(var0 == 1402) {
         var3.field2302 = var6;
      } else if(var0 == 1403) {
         var3.field2293 = var6;
      } else if(var0 == 1404) {
         var3.field2295 = var6;
      } else if(var0 == 1405) {
         var3.field2296 = var6;
      } else if(var0 == 1406) {
         var3.field2334 = var6;
      } else if(var0 == 1407) {
         var3.field2300 = var6;
         var3.field2301 = var5;
      } else if(var0 == 1408) {
         var3.field2306 = var6;
      } else if(var0 == 1409) {
         var3.field2307 = var6;
      } else if(var0 == 1410) {
         var3.field2297 = var6;
      } else if(var0 == 1411) {
         var3.field2209 = var6;
      } else if(var0 == 1412) {
         var3.field2294 = var6;
      } else if(var0 == 1414) {
         var3.field2269 = var6;
         var3.field2264 = var5;
      } else if(var0 == 1415) {
         var3.field2304 = var6;
         var3.field2305 = var5;
      } else if(var0 == 1416) {
         var3.field2261 = var6;
      } else if(var0 == 1417) {
         var3.field2308 = var6;
      } else if(var0 == 1418) {
         var3.field2309 = var6;
      } else if(var0 == 1419) {
         var3.field2310 = var6;
      } else if(var0 == 1420) {
         var3.field2311 = var6;
      } else if(var0 == 1421) {
         var3.field2317 = var6;
      } else if(var0 == 1422) {
         var3.field2220 = var6;
      } else if(var0 == 1423) {
         var3.field2314 = var6;
      } else if(var0 == 1424) {
         var3.field2315 = var6;
      } else if(var0 == 1425) {
         var3.field2222 = var6;
      } else if(var0 == 1426) {
         var3.field2318 = var6;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2316 = var6;
      }

      var3.field2285 = true;
      return 1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1987791141"
   )
   public final synchronized void method1089() {
      this.field1043 = true;

      try {
         this.vmethod1154();
      } catch (Exception var2) {
         this.vmethod1147();
         this.field1034 = class72.method1421() + 2000L;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-962953816"
   )
   void vmethod1144(int var1) throws Exception {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-283814420"
   )
   final void method1117(int var1) {
      this.field1045 -= var1;
      if(this.field1045 < 0) {
         this.field1045 = 0;
      }

      if(this.field1042 != null) {
         this.field1042.vmethod3094(var1);
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILScript;ZS)I",
      garbageValue = "-23108"
   )
   static int method1118(int var0, Script var1, boolean var2) {
      if(var0 == 5000) {
         class32.intStack[++class32.intStackSize - 1] = Client.field323;
         return 1;
      } else if(var0 == 5001) {
         class32.intStackSize -= 3;
         Client.field323 = class32.intStack[class32.intStackSize];
         Friend.field157 = class211.method4013(class32.intStack[class32.intStackSize + 1]);
         if(Friend.field157 == null) {
            Friend.field157 = class220.field3199;
         }

         Client.field468 = class32.intStack[class32.intStackSize + 2];
         Client.secretPacketBuffer1.putOpcode(202);
         Client.secretPacketBuffer1.putByte(Client.field323);
         Client.secretPacketBuffer1.putByte(Friend.field157.field3201);
         Client.secretPacketBuffer1.putByte(Client.field468);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         if(var0 == 5002) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            class32.intStackSize -= 2;
            var4 = class32.intStack[class32.intStackSize];
            var5 = class32.intStack[class32.intStackSize + 1];
            Client.secretPacketBuffer1.putOpcode(168);
            Client.secretPacketBuffer1.putByte(class36.method753(var3) + 2);
            Client.secretPacketBuffer1.method2504(var3);
            Client.secretPacketBuffer1.putByte(var4 - 1);
            Client.secretPacketBuffer1.putByte(var5);
            return 1;
         } else {
            int var11;
            if(var0 == 5003) {
               class32.intStackSize -= 2;
               var11 = class32.intStack[class32.intStackSize];
               var4 = class32.intStack[class32.intStackSize + 1];
               ChatLineBuffer var12 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var11));
               MessageNode var16 = var12.method924(var4);
               if(var16 != null) {
                  class32.intStack[++class32.intStackSize - 1] = var16.id;
                  class32.intStack[++class32.intStackSize - 1] = var16.tick;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var16.name != null?var16.name:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var16.sender != null?var16.sender:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var16.value != null?var16.value:"";
               } else {
                  class32.intStack[++class32.intStackSize - 1] = -1;
                  class32.intStack[++class32.intStackSize - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5004) {
               var11 = class32.intStack[--class32.intStackSize];
               MessageNode var18 = (MessageNode)class47.field924.method2728((long)var11);
               if(var18 != null) {
                  class32.intStack[++class32.intStackSize - 1] = var18.type;
                  class32.intStack[++class32.intStackSize - 1] = var18.tick;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var18.name != null?var18.name:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var18.sender != null?var18.sender:"";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var18.value != null?var18.value:"";
               } else {
                  class32.intStack[++class32.intStackSize - 1] = -1;
                  class32.intStack[++class32.intStackSize - 1] = 0;
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 5005) {
               if(Friend.field157 == null) {
                  class32.intStack[++class32.intStackSize - 1] = -1;
               } else {
                  class32.intStack[++class32.intStackSize - 1] = Friend.field157.field3201;
               }

               return 1;
            } else if(var0 == 5008) {
               var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
               var4 = class32.intStack[--class32.intStackSize];
               String var10 = var3.toLowerCase();
               byte var14 = 0;
               if(var10.startsWith("yellow:")) {
                  var14 = 0;
                  var3 = var3.substring("yellow:".length());
               } else if(var10.startsWith("red:")) {
                  var14 = 1;
                  var3 = var3.substring("red:".length());
               } else if(var10.startsWith("green:")) {
                  var14 = 2;
                  var3 = var3.substring("green:".length());
               } else if(var10.startsWith("cyan:")) {
                  var14 = 3;
                  var3 = var3.substring("cyan:".length());
               } else if(var10.startsWith("purple:")) {
                  var14 = 4;
                  var3 = var3.substring("purple:".length());
               } else if(var10.startsWith("white:")) {
                  var14 = 5;
                  var3 = var3.substring("white:".length());
               } else if(var10.startsWith("flash1:")) {
                  var14 = 6;
                  var3 = var3.substring("flash1:".length());
               } else if(var10.startsWith("flash2:")) {
                  var14 = 7;
                  var3 = var3.substring("flash2:".length());
               } else if(var10.startsWith("flash3:")) {
                  var14 = 8;
                  var3 = var3.substring("flash3:".length());
               } else if(var10.startsWith("glow1:")) {
                  var14 = 9;
                  var3 = var3.substring("glow1:".length());
               } else if(var10.startsWith("glow2:")) {
                  var14 = 10;
                  var3 = var3.substring("glow2:".length());
               } else if(var10.startsWith("glow3:")) {
                  var14 = 11;
                  var3 = var3.substring("glow3:".length());
               } else if(Client.field286 != 0) {
                  if(var10.startsWith("yellow:")) {
                     var14 = 0;
                     var3 = var3.substring("yellow:".length());
                  } else if(var10.startsWith("red:")) {
                     var14 = 1;
                     var3 = var3.substring("red:".length());
                  } else if(var10.startsWith("green:")) {
                     var14 = 2;
                     var3 = var3.substring("green:".length());
                  } else if(var10.startsWith("cyan:")) {
                     var14 = 3;
                     var3 = var3.substring("cyan:".length());
                  } else if(var10.startsWith("purple:")) {
                     var14 = 4;
                     var3 = var3.substring("purple:".length());
                  } else if(var10.startsWith("white:")) {
                     var14 = 5;
                     var3 = var3.substring("white:".length());
                  } else if(var10.startsWith("flash1:")) {
                     var14 = 6;
                     var3 = var3.substring("flash1:".length());
                  } else if(var10.startsWith("flash2:")) {
                     var14 = 7;
                     var3 = var3.substring("flash2:".length());
                  } else if(var10.startsWith("flash3:")) {
                     var14 = 8;
                     var3 = var3.substring("flash3:".length());
                  } else if(var10.startsWith("glow1:")) {
                     var14 = 9;
                     var3 = var3.substring("glow1:".length());
                  } else if(var10.startsWith("glow2:")) {
                     var14 = 10;
                     var3 = var3.substring("glow2:".length());
                  } else if(var10.startsWith("glow3:")) {
                     var14 = 11;
                     var3 = var3.substring("glow3:".length());
                  }
               }

               var10 = var3.toLowerCase();
               byte var7 = 0;
               if(var10.startsWith("wave:")) {
                  var7 = 1;
                  var3 = var3.substring("wave:".length());
               } else if(var10.startsWith("wave2:")) {
                  var7 = 2;
                  var3 = var3.substring("wave2:".length());
               } else if(var10.startsWith("shake:")) {
                  var7 = 3;
                  var3 = var3.substring("shake:".length());
               } else if(var10.startsWith("scroll:")) {
                  var7 = 4;
                  var3 = var3.substring("scroll:".length());
               } else if(var10.startsWith("slide:")) {
                  var7 = 5;
                  var3 = var3.substring("slide:".length());
               } else if(Client.field286 != 0) {
                  if(var10.startsWith("wave:")) {
                     var7 = 1;
                     var3 = var3.substring("wave:".length());
                  } else if(var10.startsWith("wave2:")) {
                     var7 = 2;
                     var3 = var3.substring("wave2:".length());
                  } else if(var10.startsWith("shake:")) {
                     var7 = 3;
                     var3 = var3.substring("shake:".length());
                  } else if(var10.startsWith("scroll:")) {
                     var7 = 4;
                     var3 = var3.substring("scroll:".length());
                  } else if(var10.startsWith("slide:")) {
                     var7 = 5;
                     var3 = var3.substring("slide:".length());
                  }
               }

               Client.secretPacketBuffer1.putOpcode(56);
               Client.secretPacketBuffer1.putByte(0);
               int var8 = Client.secretPacketBuffer1.offset;
               Client.secretPacketBuffer1.putByte(var4);
               Client.secretPacketBuffer1.putByte(var14);
               Client.secretPacketBuffer1.putByte(var7);
               class38.method767(Client.secretPacketBuffer1, var3);
               Client.secretPacketBuffer1.method2380(Client.secretPacketBuffer1.offset - var8);
               return 1;
            } else if(var0 == 5009) {
               class32.scriptStringStackSize -= 2;
               var3 = class32.scriptStringStack[class32.scriptStringStackSize];
               String var17 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
               Client.secretPacketBuffer1.putOpcode(83);
               Client.secretPacketBuffer1.putShort(0);
               var5 = Client.secretPacketBuffer1.offset;
               Client.secretPacketBuffer1.method2504(var3);
               class38.method767(Client.secretPacketBuffer1, var17);
               Client.secretPacketBuffer1.method2379(Client.secretPacketBuffer1.offset - var5);
               return 1;
            } else if(var0 != 5015) {
               if(var0 == 5016) {
                  class32.intStack[++class32.intStackSize - 1] = Client.field468;
                  return 1;
               } else {
                  int var6;
                  int[] var13;
                  if(var0 == 5017) {
                     var11 = class32.intStack[--class32.intStackSize];
                     var13 = class32.intStack;
                     var5 = ++class32.intStackSize - 1;
                     ChatLineBuffer var15 = (ChatLineBuffer)class47.chatLineMap.get(Integer.valueOf(var11));
                     if(var15 == null) {
                        var6 = 0;
                     } else {
                        var6 = var15.method930();
                     }

                     var13[var5] = var6;
                     return 1;
                  } else {
                     MessageNode var9;
                     if(var0 == 5018) {
                        var11 = class32.intStack[--class32.intStackSize];
                        var13 = class32.intStack;
                        var5 = ++class32.intStackSize - 1;
                        var9 = (MessageNode)class47.field924.method2728((long)var11);
                        if(var9 == null) {
                           var6 = -1;
                        } else if(class47.field927.field2051 == var9.previous) {
                           var6 = -1;
                        } else {
                           var6 = ((MessageNode)var9.previous).id;
                        }

                        var13[var5] = var6;
                        return 1;
                     } else if(var0 == 5019) {
                        var11 = class32.intStack[--class32.intStackSize];
                        var13 = class32.intStack;
                        var5 = ++class32.intStackSize - 1;
                        var9 = (MessageNode)class47.field924.method2728((long)var11);
                        if(var9 == null) {
                           var6 = -1;
                        } else if(var9.next == class47.field927.field2051) {
                           var6 = -1;
                        } else {
                           var6 = ((MessageNode)var9.next).id;
                        }

                        var13[var5] = var6;
                        return 1;
                     } else if(var0 == 5020) {
                        var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                        if(var3.equalsIgnoreCase("toggleroof")) {
                           Actor.field656.field690 = !Actor.field656.field690;
                           Renderable.method1896();
                           if(Actor.field656.field690) {
                              WidgetNode.sendGameMessage(99, "", "Roofs are now all hidden");
                           } else {
                              WidgetNode.sendGameMessage(99, "", "Roofs will only be removed selectively");
                           }
                        }

                        if(var3.equalsIgnoreCase("displayfps")) {
                           Client.field558 = !Client.field558;
                        }

                        if(Client.field517 >= 2) {
                           if(var3.equalsIgnoreCase("fpson")) {
                              Client.field558 = true;
                           }

                           if(var3.equalsIgnoreCase("fpsoff")) {
                              Client.field558 = false;
                           }

                           if(var3.equalsIgnoreCase("gc")) {
                              System.gc();
                           }

                           if(var3.equalsIgnoreCase("clientdrop")) {
                              class0.method11();
                           }

                           if(var3.equalsIgnoreCase("errortest") && Client.field283 == 2) {
                              throw new RuntimeException();
                           }
                        }

                        Client.secretPacketBuffer1.putOpcode(161);
                        Client.secretPacketBuffer1.putByte(var3.length() + 1);
                        Client.secretPacketBuffer1.method2504(var3);
                        return 1;
                     } else if(var0 == 5021) {
                        Client.field460 = class32.scriptStringStack[--class32.scriptStringStackSize].toLowerCase().trim();
                        return 1;
                     } else if(var0 == 5022) {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Client.field460;
                        return 1;
                     } else {
                        return 2;
                     }
                  }
               }
            } else {
               if(class22.localPlayer != null && class22.localPlayer.name != null) {
                  var3 = class22.localPlayer.name;
               } else {
                  var3 = "";
               }

               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3;
               return 1;
            }
         }
      }
   }
}
