import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("ObjectComposition")
public class ObjectComposition extends CacheableNode {
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -123983951
   )
   public int field947 = 0;
   @ObfuscatedName("d")
   static class170 field948;
   @ObfuscatedName("v")
   static class170 field949;
   @ObfuscatedName("r")
   public static NodeCache field950 = new NodeCache(64);
   @ObfuscatedName("ah")
   @Export("impostorIds")
   public int[] impostorIds;
   @ObfuscatedName("t")
   public static NodeCache field952 = new NodeCache(30);
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -823922617
   )
   int field953 = 128;
   @ObfuscatedName("u")
   short[] field954;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -694335933
   )
   public int field955;
   @ObfuscatedName("m")
   int[] field956;
   @ObfuscatedName("k")
   int[] field957;
   @ObfuscatedName("x")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("n")
   public static NodeCache field959 = new NodeCache(30);
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -314455983
   )
   public int field960 = -1;
   @ObfuscatedName("q")
   short[] field961;
   @ObfuscatedName("l")
   public boolean field962 = false;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 549948841
   )
   public int field963 = 1;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 438388817
   )
   public int field964 = 1;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 562039887
   )
   public int field965 = 2;
   @ObfuscatedName("y")
   public boolean field966 = true;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 792909651
   )
   public int field967 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1526993899
   )
   public int field968 = 0;
   @ObfuscatedName("h")
   boolean field969 = false;
   @ObfuscatedName("w")
   short[] field970;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1356955519
   )
   public int field971 = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -900965365
   )
   public int field972 = 16;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -344467103
   )
   int field973 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1969641035
   )
   int field974 = 0;
   @ObfuscatedName("af")
   @Export("actions")
   public String[] actions = new String[5];
   @ObfuscatedName("ae")
   public int[] field976;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 646386445
   )
   public int field977 = -1;
   @ObfuscatedName("i")
   static ModelData[] field978 = new ModelData[4];
   @ObfuscatedName("ar")
   public boolean field979 = true;
   @ObfuscatedName("z")
   public static NodeCache field980 = new NodeCache(500);
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 646809743
   )
   int field981 = 128;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -583560625
   )
   int field982 = 128;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 583805497
   )
   int field983 = 0;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 101101623
   )
   int field984 = 0;
   @ObfuscatedName("aa")
   boolean field985 = false;
   @ObfuscatedName("ab")
   public boolean field986 = false;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1929965833
   )
   int field987 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 861244353
   )
   public int field988 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -397393077
   )
   public int field989 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -397361413
   )
   int field990 = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1283198661
   )
   int field991 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 811513505
   )
   public int field992 = 0;
   @ObfuscatedName("a")
   static boolean field993 = false;
   @ObfuscatedName("j")
   short[] field994;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1173073521
   )
   int field995 = 0;
   @ObfuscatedName("al")
   boolean field996 = false;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2124857611"
   )
   void method837() {
      if(this.field967 == -1) {
         this.field967 = 0;
         if(null != this.field956 && (this.field957 == null || this.field957[0] == 10)) {
            this.field967 = 1;
         }

         for(int var1 = 0; var1 < 5; ++var1) {
            if(this.actions[var1] != null) {
               this.field967 = 1;
            }
         }
      }

      if(this.field988 == -1) {
         this.field988 = this.field965 != 0?1:0;
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "255973199"
   )
   void method838(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method839(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1633691913"
   )
   void method839(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.method2528();
         if(var3 > 0) {
            if(this.field956 != null && !field993) {
               var1.offset += 3 * var3;
            } else {
               this.field957 = new int[var3];
               this.field956 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field956[var4] = var1.method2717();
                  this.field957[var4] = var1.method2528();
               }
            }
         }
      } else if(var2 == 2) {
         this.name = var1.method2530();
      } else if(var2 == 5) {
         var3 = var1.method2528();
         if(var3 > 0) {
            if(this.field956 != null && !field993) {
               var1.offset += var3 * 2;
            } else {
               this.field957 = null;
               this.field956 = new int[var3];

               for(var4 = 0; var4 < var3; ++var4) {
                  this.field956[var4] = var1.method2717();
               }
            }
         }
      } else if(var2 == 14) {
         this.field963 = var1.method2528();
      } else if(var2 == 15) {
         this.field964 = var1.method2528();
      } else if(var2 == 17) {
         this.field965 = 0;
         this.field966 = false;
      } else if(var2 == 18) {
         this.field966 = false;
      } else if(var2 == 19) {
         this.field967 = var1.method2528();
      } else if(var2 == 21) {
         this.field987 = 0;
      } else if(var2 == 22) {
         this.field969 = true;
      } else if(var2 == 23) {
         this.field962 = true;
      } else if(var2 == 24) {
         this.field989 = var1.method2717();
         if(this.field989 == '\uffff') {
            this.field989 = -1;
         }
      } else if(var2 == 27) {
         this.field965 = 1;
      } else if(var2 == 28) {
         this.field972 = var1.method2528();
      } else if(var2 == 29) {
         this.field973 = var1.method2529();
      } else if(var2 == 39) {
         this.field974 = var1.method2529() * 25;
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.method2530();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.method2528();
         this.field954 = new short[var3];
         this.field994 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field954[var4] = (short)var1.method2717();
            this.field994[var4] = (short)var1.method2717();
         }
      } else if(var2 == 41) {
         var3 = var1.method2528();
         this.field961 = new short[var3];
         this.field970 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field961[var4] = (short)var1.method2717();
            this.field970[var4] = (short)var1.method2717();
         }
      } else if(var2 == 60) {
         this.field971 = var1.method2717();
      } else if(var2 == 62) {
         this.field985 = true;
      } else if(var2 == 64) {
         this.field979 = false;
      } else if(var2 == 65) {
         this.field953 = var1.method2717();
      } else if(var2 == 66) {
         this.field981 = var1.method2717();
      } else if(var2 == 67) {
         this.field982 = var1.method2717();
      } else if(var2 == 68) {
         this.field977 = var1.method2717();
      } else if(var2 == 69) {
         var1.method2528();
      } else if(var2 == 70) {
         this.field983 = var1.method2618();
      } else if(var2 == 71) {
         this.field984 = var1.method2618();
      } else if(var2 == 72) {
         this.field995 = var1.method2618();
      } else if(var2 == 73) {
         this.field986 = true;
      } else if(var2 == 74) {
         this.field996 = true;
      } else if(var2 == 75) {
         this.field988 = var1.method2528();
      } else if(var2 == 77) {
         this.field990 = var1.method2717();
         if(this.field990 == '\uffff') {
            this.field990 = -1;
         }

         this.field991 = var1.method2717();
         if(this.field991 == '\uffff') {
            this.field991 = -1;
         }

         var3 = var1.method2528();
         this.impostorIds = new int[var3 + 1];

         for(var4 = 0; var4 <= var3; ++var4) {
            this.impostorIds[var4] = var1.method2717();
            if(this.impostorIds[var4] == '\uffff') {
               this.impostorIds[var4] = -1;
            }
         }
      } else if(var2 == 78) {
         this.field960 = var1.method2717();
         this.field968 = var1.method2528();
      } else if(var2 == 79) {
         this.field992 = var1.method2717();
         this.field947 = var1.method2717();
         this.field968 = var1.method2528();
         var3 = var1.method2528();
         this.field976 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field976[var4] = var1.method2717();
         }
      } else if(var2 == 81) {
         this.field987 = var1.method2528() * 256;
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1144195851"
   )
   public final boolean method840(int var1) {
      if(null != this.field957) {
         for(int var4 = 0; var4 < this.field957.length; ++var4) {
            if(this.field957[var4] == var1) {
               return field949.method3351(this.field956[var4] & '\uffff', 0);
            }
         }

         return true;
      } else if(this.field956 == null) {
         return true;
      } else if(var1 != 10) {
         return true;
      } else {
         boolean var2 = true;

         for(int var3 = 0; var3 < this.field956.length; ++var3) {
            var2 &= field949.method3351(this.field956[var3] & '\uffff', 0);
         }

         return var2;
      }
   }

   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      signature = "(LNPCComposition;IIII)V",
      garbageValue = "-1588194905"
   )
   static final void method841(NPCComposition var0, int var1, int var2, int var3) {
      if(Client.menuOptionCount < 400) {
         if(null != var0.field923) {
            var0 = var0.method810();
         }

         if(var0 != null) {
            if(var0.field942) {
               if(!var0.field944 || var1 == Client.field418) {
                  String var4 = var0.name;
                  int var8;
                  if(var0.combatLevel != 0) {
                     int var7 = var0.combatLevel;
                     var8 = WidgetNode.localPlayer.combatLevel;
                     int var9 = var8 - var7;
                     String var10;
                     if(var9 < -9) {
                        var10 = class153.method3186(16711680);
                     } else if(var9 < -6) {
                        var10 = class153.method3186(16723968);
                     } else if(var9 < -3) {
                        var10 = class153.method3186(16740352);
                     } else if(var9 < 0) {
                        var10 = class153.method3186(16756736);
                     } else if(var9 > 9) {
                        var10 = class153.method3186('\uff00');
                     } else if(var9 > 6) {
                        var10 = class153.method3186(4259584);
                     } else if(var9 > 3) {
                        var10 = class153.method3186(8453888);
                     } else if(var9 > 0) {
                        var10 = class153.method3186(12648192);
                     } else {
                        var10 = class153.method3186(16776960);
                     }

                     var4 = var4 + var10 + " " + " (" + "level-" + var0.combatLevel + ")";
                  }

                  if(Client.field524 == 1) {
                     Ignore.addMenuEntry("Use", Client.field529 + " " + "->" + " " + class153.method3186(16776960) + var4, 7, var1, var2, var3);
                  } else if(Client.field435) {
                     if((class50.field1116 & 2) == 2) {
                        Ignore.addMenuEntry(Client.field438, Client.field439 + " " + "->" + " " + class153.method3186(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.actions;
                     if(Client.field412) {
                        var5 = class13.method165(var5);
                     }

                     int var6;
                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var11 = 0;
                              if(var6 == 0) {
                                 var11 = 9;
                              }

                              if(var6 == 1) {
                                 var11 = 10;
                              }

                              if(var6 == 2) {
                                 var11 = 11;
                              }

                              if(var6 == 3) {
                                 var11 = 12;
                              }

                              if(var6 == 4) {
                                 var11 = 13;
                              }

                              Ignore.addMenuEntry(var5[var6], class153.method3186(16776960) + var4, var11, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && var5[var6].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(Client.field307 != class21.field581) {
                                 if(Client.field307 == class21.field578 || class21.field587 == Client.field307 && var0.combatLevel > WidgetNode.localPlayer.combatLevel) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(var6 == 0) {
                                    var8 = 9 + var12;
                                 }

                                 if(var6 == 1) {
                                    var8 = 10 + var12;
                                 }

                                 if(var6 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(var6 == 3) {
                                    var8 = 12 + var12;
                                 }

                                 if(var6 == 4) {
                                    var8 = var12 + 13;
                                 }

                                 Ignore.addMenuEntry(var5[var6], class153.method3186(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     Ignore.addMenuEntry("Examine", class153.method3186(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[[IIIII)LRenderable;",
      garbageValue = "252647357"
   )
   public final Renderable method842(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(this.field957 == null) {
         var7 = (long)(var2 + (this.field955 << 10));
      } else {
         var7 = (long)(var2 + (this.field955 << 10) + (var1 << 3));
      }

      Object var9 = (Renderable)field952.get(var7);
      if(null == var9) {
         ModelData var10 = this.method857(var1, var2);
         if(null == var10) {
            return null;
         }

         if(!this.field969) {
            var9 = var10.method2247(this.field973 + 64, 768 + this.field974, -50, -10, -50);
         } else {
            var10.field1806 = (short)(this.field973 + 64);
            var10.field1788 = (short)(768 + this.field974);
            var10.computeNormals();
            var9 = var10;
         }

         field952.put((CacheableNode)var9, var7);
      }

      if(this.field969) {
         var9 = ((ModelData)var9).method2301();
      }

      if(this.field987 >= 0) {
         if(var9 instanceof Model) {
            var9 = ((Model)var9).method2321(var3, var4, var5, var6, true, this.field987);
         } else if(var9 instanceof ModelData) {
            var9 = ((ModelData)var9).method2232(var3, var4, var5, var6, true, this.field987);
         }
      }

      return (Renderable)var9;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II[[IIIIB)LModel;",
      garbageValue = "107"
   )
   public final Model method843(int var1, int var2, int[][] var3, int var4, int var5, int var6) {
      long var7;
      if(null == this.field957) {
         var7 = (long)((this.field955 << 10) + var2);
      } else {
         var7 = (long)((var1 << 3) + (this.field955 << 10) + var2);
      }

      Model var9 = (Model)field959.get(var7);
      if(null == var9) {
         ModelData var10 = this.method857(var1, var2);
         if(var10 == null) {
            return null;
         }

         var9 = var10.method2247(64 + this.field973, this.field974 + 768, -50, -10, -50);
         field959.put(var9, var7);
      }

      if(this.field987 >= 0) {
         var9 = var9.method2321(var3, var4, var5, var6, true, this.field987);
      }

      return var9;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[[IIIILSequence;II)LModel;",
      garbageValue = "-1869782281"
   )
   public final Model method844(int var1, int var2, int[][] var3, int var4, int var5, int var6, Sequence var7, int var8) {
      long var9;
      if(this.field957 == null) {
         var9 = (long)(var2 + (this.field955 << 10));
      } else {
         var9 = (long)((this.field955 << 10) + (var1 << 3) + var2);
      }

      Model var11 = (Model)field959.get(var9);
      if(var11 == null) {
         ModelData var12 = this.method857(var1, var2);
         if(var12 == null) {
            return null;
         }

         var11 = var12.method2247(this.field973 + 64, 768 + this.field974, -50, -10, -50);
         field959.put(var11, var9);
      }

      if(var7 == null && this.field987 == -1) {
         return var11;
      } else {
         if(null != var7) {
            var11 = var7.method904(var11, var8, var2);
         } else {
            var11 = var11.method2358(true);
         }

         if(this.field987 >= 0) {
            var11 = var11.method2321(var3, var4, var5, var6, false, this.field987);
         }

         return var11;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "-2121555381"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field932.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field922.method3309(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method806(new Buffer(var2));
         }

         var1.method814();
         NPCComposition.field932.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-4"
   )
   public boolean method847() {
      if(this.impostorIds == null) {
         return this.field960 != -1 || null != this.field976;
      } else {
         for(int var1 = 0; var1 < this.impostorIds.length; ++var1) {
            if(this.impostorIds[var1] != -1) {
               ObjectComposition var2 = class165.getObjectDefinition(this.impostorIds[var1]);
               if(var2.field960 != -1 || var2.field976 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)LModelData;",
      garbageValue = "-131876103"
   )
   final ModelData method857(int var1, int var2) {
      ModelData var3 = null;
      boolean var4;
      int var5;
      int var7;
      if(null == this.field957) {
         if(var1 != 10) {
            return null;
         }

         if(this.field956 == null) {
            return null;
         }

         var4 = this.field985;
         if(var1 == 2 && var2 > 3) {
            var4 = !var4;
         }

         var5 = this.field956.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            var7 = this.field956[var6];
            if(var4) {
               var7 += 65536;
            }

            var3 = (ModelData)field980.get((long)var7);
            if(var3 == null) {
               var3 = ModelData.method2284(field949, var7 & '\uffff', 0);
               if(null == var3) {
                  return null;
               }

               if(var4) {
                  var3.method2241();
               }

               field980.put(var3, (long)var7);
            }

            if(var5 > 1) {
               field978[var6] = var3;
            }
         }

         if(var5 > 1) {
            var3 = new ModelData(field978, var5);
         }
      } else {
         int var9 = -1;

         for(var5 = 0; var5 < this.field957.length; ++var5) {
            if(var1 == this.field957[var5]) {
               var9 = var5;
               break;
            }
         }

         if(var9 == -1) {
            return null;
         }

         var5 = this.field956[var9];
         boolean var10 = this.field985 ^ var2 > 3;
         if(var10) {
            var5 += 65536;
         }

         var3 = (ModelData)field980.get((long)var5);
         if(null == var3) {
            var3 = ModelData.method2284(field949, var5 & '\uffff', 0);
            if(null == var3) {
               return null;
            }

            if(var10) {
               var3.method2241();
            }

            field980.put(var3, (long)var5);
         }
      }

      if(this.field953 == 128 && this.field981 == 128 && this.field982 == 128) {
         var4 = false;
      } else {
         var4 = true;
      }

      boolean var11;
      if(this.field983 == 0 && this.field984 == 0 && this.field995 == 0) {
         var11 = false;
      } else {
         var11 = true;
      }

      ModelData var8 = new ModelData(var3, var2 == 0 && !var4 && !var11, this.field954 == null, this.field961 == null, true);
      if(var1 == 4 && var2 > 3) {
         var8.method2237(256);
         var8.method2230(45, 0, -45);
      }

      var2 &= 3;
      if(var2 == 1) {
         var8.method2234();
      } else if(var2 == 2) {
         var8.method2276();
      } else if(var2 == 3) {
         var8.method2236();
      }

      if(null != this.field954) {
         for(var7 = 0; var7 < this.field954.length; ++var7) {
            var8.method2239(this.field954[var7], this.field994[var7]);
         }
      }

      if(this.field961 != null) {
         for(var7 = 0; var7 < this.field961.length; ++var7) {
            var8.method2240(this.field961[var7], this.field970[var7]);
         }
      }

      if(var4) {
         var8.method2270(this.field953, this.field981, this.field982);
      }

      if(var11) {
         var8.method2230(this.field983, this.field984, this.field995);
      }

      return var8;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)LObjectComposition;",
      garbageValue = "888897917"
   )
   @Export("getImpostor")
   public final ObjectComposition getImpostor() {
      int var1 = -1;
      if(this.field990 != -1) {
         var1 = class153.method3184(this.field990);
      } else if(this.field991 != -1) {
         var1 = class179.widgetSettings[this.field991];
      }

      return var1 >= 0 && var1 < this.impostorIds.length && this.impostorIds[var1] != -1?class165.getObjectDefinition(this.impostorIds[var1]):null;
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-23"
   )
   static void method882(int var0) {
      for(class204 var1 = (class204)Client.widgetFlags.method3820(); var1 != null; var1 = (class204)Client.widgetFlags.method3827()) {
         if((long)var0 == (var1.hash >> 48 & 65535L)) {
            var1.unlink();
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1458048215"
   )
   static final int method883(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class11.method156(var3, var5);
      int var8 = class11.method156(var3 + 1, var5);
      int var9 = class11.method156(var3, 1 + var5);
      int var10 = class11.method156(1 + var3, var5 + 1);
      int var11 = Player.method22(var7, var8, var4, var2);
      int var12 = Player.method22(var9, var10, var4, var2);
      return Player.method22(var11, var12, var6, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "569431483"
   )
   public final boolean method884() {
      if(this.field956 == null) {
         return true;
      } else {
         boolean var1 = true;

         for(int var2 = 0; var2 < this.field956.length; ++var2) {
            var1 &= field949.method3351(this.field956[var2] & '\uffff', 0);
         }

         return var1;
      }
   }
}
