import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
public class class103 implements Runnable {
   @ObfuscatedName("d")
   static String field1674;
   @ObfuscatedName("h")
   class102 field1675 = null;
   @ObfuscatedName("p")
   class102 field1676 = null;
   @ObfuscatedName("r")
   EventQueue field1677;
   @ObfuscatedName("n")
   boolean field1678 = false;
   @ObfuscatedName("j")
   Thread field1679;
   @ObfuscatedName("qj")
   @ObfuscatedGetter(
      intValue = -2066754447
   )
   protected static int field1683;
   @ObfuscatedName("q")
   static String field1685;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 208255649
   )
   static int scriptIntStackSize;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1200165618"
   )
   final void method2022() {
      synchronized(this) {
         this.field1678 = true;
         this.notifyAll();
      }

      try {
         this.field1679.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1678) {
                  return;
               }

               if(null != this.field1675) {
                  var1 = this.field1675;
                  this.field1675 = this.field1675.field1668;
                  if(null == this.field1675) {
                     this.field1676 = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var8) {
                  ;
               }
            }
         }

         try {
            int var5 = var1.field1669;
            if(var5 == 1) {
               var1.field1672 = new Socket(InetAddress.getByName((String)var1.field1666), var1.field1667);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1666);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1667);
               var1.field1672 = var3;
            } else if(var5 == 4) {
               var1.field1672 = new DataInputStream(((URL)var1.field1666).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1667 >> 24 & 255) + "." + (var1.field1667 >> 16 & 255) + "." + (var1.field1667 >> 8 & 255) + "." + (var1.field1667 & 255);
               var1.field1672 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1671 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1671 = 2;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;B)Lclass102;",
      garbageValue = "37"
   )
   final class102 method2023(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1669 = var1;
      var5.field1667 = var2;
      var5.field1666 = var4;
      synchronized(this) {
         if(null != this.field1676) {
            this.field1676.field1668 = var5;
            this.field1676 = var5;
         } else {
            this.field1676 = this.field1675 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass102;",
      garbageValue = "-1972571091"
   )
   public final class102 method2024(String var1, int var2) {
      return this.method2023(1, var2, 0, var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass102;",
      garbageValue = "-1224342177"
   )
   public final class102 method2025(Runnable var1, int var2) {
      return this.method2023(2, var2, 0, var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lclass145;B)V",
      garbageValue = "1"
   )
   public static void method2026(class145 var0) {
      class210.field3126 = var0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)Lclass102;",
      garbageValue = "31"
   )
   public final class102 method2029(int var1) {
      return this.method2023(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-2138620028"
   )
   static final void method2033(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class10.field118[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var0 + var2 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var3 + var1 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 + 1];
               }
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass102;",
      garbageValue = "1303709595"
   )
   public final class102 method2035(URL var1) {
      return this.method2023(4, 0, 0, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-1320434535"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field2953.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field2949.getConfigData(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method3662();
         if(var1.notedTemplate != -1) {
            var1.method3716(getItemDefinition(var1.notedTemplate), getItemDefinition(var1.note));
         }

         if(var1.field2969 != -1) {
            var1.method3666(getItemDefinition(var1.field2969), getItemDefinition(var1.field2998));
         }

         if(var1.field2976 != -1) {
            var1.method3667(getItemDefinition(var1.field2976), getItemDefinition(var1.field3000));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field2997 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.team = -1;
            var1.field2948 = 0;
         }

         ItemComposition.field2953.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ILclass48;ZI)I",
      garbageValue = "474794473"
   )
   static int method2043(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if(var0 == 4100) {
         var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
         var4 = class32.scriptIntStack[--scriptIntStackSize];
         class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var37;
         if(var0 == 4101) {
            class32.scriptStringStackSize -= 2;
            var3 = class32.scriptStringStack[class32.scriptStringStackSize];
            var37 = class32.scriptStringStack[1 + class32.scriptStringStackSize];
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3 + var37;
            return 1;
         } else if(var0 == 4102) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            var4 = class32.scriptIntStack[--scriptIntStackSize];
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3 + class178.method3288(var4, true);
            return 1;
         } else if(var0 == 4103) {
            var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var8;
            int var21;
            int var29;
            if(var0 == 4104) {
               var21 = class32.scriptIntStack[--scriptIntStackSize];
               long var22 = (11745L + (long)var21) * 86400000L;
               class32.field759.setTime(new Date(var22));
               var29 = class32.field759.get(5);
               int var28 = class32.field759.get(2);
               var8 = class32.field759.get(1);
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var29 + "-" + class32.field753[var28] + "-" + var8;
               return 1;
            } else if(var0 == 4105) {
               class32.scriptStringStackSize -= 2;
               var3 = class32.scriptStringStack[class32.scriptStringStackSize];
               var37 = class32.scriptStringStack[1 + class32.scriptStringStackSize];
               if(null != class36.localPlayer.composition && class36.localPlayer.composition.isFemale) {
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var37;
               } else {
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4106) {
               var21 = class32.scriptIntStack[--scriptIntStackSize];
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = Integer.toString(var21);
               return 1;
            } else {
               int var5;
               if(var0 == 4107) {
                  class32.scriptStringStackSize -= 2;
                  int[] var27 = class32.scriptIntStack;
                  var4 = ++scriptIntStackSize - 1;
                  String var39 = class32.scriptStringStack[class32.scriptStringStackSize];
                  String var40 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                  var8 = Client.field309;
                  int var9 = var39.length();
                  int var10 = var40.length();
                  int var11 = 0;
                  int var12 = 0;
                  byte var13 = 0;
                  byte var14 = 0;

                  label389:
                  while(true) {
                     if(var11 - var13 >= var9 && var12 - var14 >= var10) {
                        int var32 = Math.min(var9, var10);

                        int var33;
                        char var36;
                        for(var33 = 0; var33 < var32; ++var33) {
                           char var34 = var39.charAt(var33);
                           var36 = var40.charAt(var33);
                           if(var34 != var36 && Character.toUpperCase(var34) != Character.toUpperCase(var36)) {
                              var34 = Character.toLowerCase(var34);
                              var36 = Character.toLowerCase(var36);
                              if(var36 != var34) {
                                 var5 = KitDefinition.method3526(var34, var8) - KitDefinition.method3526(var36, var8);
                                 break label389;
                              }
                           }
                        }

                        var33 = var9 - var10;
                        if(var33 != 0) {
                           var5 = var33;
                        } else {
                           for(int var35 = 0; var35 < var32; ++var35) {
                              var36 = var39.charAt(var35);
                              char var19 = var40.charAt(var35);
                              if(var19 != var36) {
                                 var5 = KitDefinition.method3526(var36, var8) - KitDefinition.method3526(var19, var8);
                                 break label389;
                              }
                           }

                           var5 = 0;
                        }
                        break;
                     }

                     if(var11 - var13 >= var9) {
                        var5 = -1;
                        break;
                     }

                     if(var12 - var14 >= var10) {
                        var5 = 1;
                        break;
                     }

                     char var15;
                     if(var13 != 0) {
                        var15 = (char)var13;
                        boolean var30 = false;
                     } else {
                        var15 = var39.charAt(var11++);
                     }

                     char var16;
                     if(var14 != 0) {
                        var16 = (char)var14;
                        boolean var31 = false;
                     } else {
                        var16 = var40.charAt(var12++);
                     }

                     byte var17;
                     if(var15 == 198) {
                        var17 = 69;
                     } else if(var15 == 230) {
                        var17 = 101;
                     } else if(var15 == 223) {
                        var17 = 115;
                     } else if(var15 == 338) {
                        var17 = 69;
                     } else if(var15 == 339) {
                        var17 = 101;
                     } else {
                        var17 = 0;
                     }

                     var13 = var17;
                     byte var18;
                     if(var16 == 198) {
                        var18 = 69;
                     } else if(var16 == 230) {
                        var18 = 101;
                     } else if(var16 == 223) {
                        var18 = 115;
                     } else if(var16 == 338) {
                        var18 = 69;
                     } else if(var16 == 339) {
                        var18 = 101;
                     } else {
                        var18 = 0;
                     }

                     var14 = var18;
                     var15 = Client.method359(var15, var8);
                     var16 = Client.method359(var16, var8);
                     if(var15 != var16 && Character.toUpperCase(var15) != Character.toUpperCase(var16)) {
                        var15 = Character.toLowerCase(var15);
                        var16 = Character.toLowerCase(var16);
                        if(var16 != var15) {
                           var5 = KitDefinition.method3526(var15, var8) - KitDefinition.method3526(var16, var8);
                           break;
                        }
                     }
                  }

                  var27[var4] = class1.method18(var5);
                  return 1;
               } else {
                  byte[] var24;
                  Font var25;
                  if(var0 == 4108) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     scriptIntStackSize -= 2;
                     var4 = class32.scriptIntStack[scriptIntStackSize];
                     var5 = class32.scriptIntStack[scriptIntStackSize + 1];
                     var24 = class0.field0.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class32.scriptIntStack[++scriptIntStackSize - 1] = var25.method3970(var3, var4);
                     return 1;
                  } else if(var0 == 4109) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     scriptIntStackSize -= 2;
                     var4 = class32.scriptIntStack[scriptIntStackSize];
                     var5 = class32.scriptIntStack[scriptIntStackSize + 1];
                     var24 = class0.field0.getConfigData(var5, 0);
                     var25 = new Font(var24);
                     class32.scriptIntStack[++scriptIntStackSize - 1] = var25.method3895(var3, var4);
                     return 1;
                  } else if(var0 == 4110) {
                     class32.scriptStringStackSize -= 2;
                     var3 = class32.scriptStringStack[class32.scriptStringStackSize];
                     var37 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                     if(class32.scriptIntStack[--scriptIntStackSize] == 1) {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3;
                     } else {
                        class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var37;
                     }

                     return 1;
                  } else if(var0 == 4111) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = FontTypeFace.method3958(var3);
                     return 1;
                  } else if(var0 == 4112) {
                     var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                     var4 = class32.scriptIntStack[--scriptIntStackSize];
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else {
                     char var7;
                     if(var0 != 4113) {
                        if(var0 == 4114) {
                           var21 = class32.scriptIntStack[--scriptIntStackSize];
                           class32.scriptIntStack[++scriptIntStackSize - 1] = class60.method1205((char)var21)?1:0;
                           return 1;
                        } else if(var0 == 4115) {
                           var21 = class32.scriptIntStack[--scriptIntStackSize];
                           class32.scriptIntStack[++scriptIntStackSize - 1] = ChatMessages.method943((char)var21)?1:0;
                           return 1;
                        } else if(var0 == 4116) {
                           var21 = class32.scriptIntStack[--scriptIntStackSize];
                           class32.scriptIntStack[++scriptIntStackSize - 1] = class22.method218((char)var21)?1:0;
                           return 1;
                        } else if(var0 == 4117) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           if(null != var3) {
                              class32.scriptIntStack[++scriptIntStackSize - 1] = var3.length();
                           } else {
                              class32.scriptIntStack[++scriptIntStackSize - 1] = 0;
                           }

                           return 1;
                        } else if(var0 == 4118) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           scriptIntStackSize -= 2;
                           var4 = class32.scriptIntStack[scriptIntStackSize];
                           var5 = class32.scriptIntStack[scriptIntStackSize + 1];
                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var3.substring(var4, var5);
                           return 1;
                        } else if(var0 == 4119) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           StringBuilder var38 = new StringBuilder(var3.length());
                           boolean var26 = false;

                           for(var29 = 0; var29 < var3.length(); ++var29) {
                              var7 = var3.charAt(var29);
                              if(var7 == 60) {
                                 var26 = true;
                              } else if(var7 == 62) {
                                 var26 = false;
                              } else if(!var26) {
                                 var38.append(var7);
                              }
                           }

                           class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var38.toString();
                           return 1;
                        } else if(var0 == 4120) {
                           var3 = class32.scriptStringStack[--class32.scriptStringStackSize];
                           var4 = class32.scriptIntStack[--scriptIntStackSize];
                           class32.scriptIntStack[++scriptIntStackSize - 1] = var3.indexOf(var4);
                           return 1;
                        } else if(var0 == 4121) {
                           class32.scriptStringStackSize -= 2;
                           var3 = class32.scriptStringStack[class32.scriptStringStackSize];
                           var37 = class32.scriptStringStack[class32.scriptStringStackSize + 1];
                           var5 = class32.scriptIntStack[--scriptIntStackSize];
                           class32.scriptIntStack[++scriptIntStackSize - 1] = var3.indexOf(var37, var5);
                           return 1;
                        } else {
                           return 2;
                        }
                     } else {
                        var21 = class32.scriptIntStack[--scriptIntStackSize];
                        int[] var20 = class32.scriptIntStack;
                        var5 = ++scriptIntStackSize - 1;
                        var7 = (char)var21;
                        boolean var6;
                        if(var7 >= 32 && var7 <= 126) {
                           var6 = true;
                        } else if(var7 >= 160 && var7 <= 255) {
                           var6 = true;
                        } else if(var7 != 8364 && var7 != 338 && var7 != 8212 && var7 != 339 && var7 != 376) {
                           var6 = false;
                        } else {
                           var6 = true;
                        }

                        var20[var5] = var6?1:0;
                        return 1;
                     }
                  }
               }
            }
         }
      }
   }

   class103() {
      field1685 = "Unknown";
      field1674 = "1.1";

      try {
         field1685 = System.getProperty("java.vendor");
         field1674 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1677 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1678 = false;
      this.field1679 = new Thread(this);
      this.field1679.setPriority(10);
      this.field1679.setDaemon(true);
      this.field1679.start();
   }
}
