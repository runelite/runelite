import java.lang.management.GarbageCollectorMXBean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("j")
   short[] field1150;
   @ObfuscatedName("t")
   public static class170 field1152;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 203804315
   )
   int field1153 = -1;
   @ObfuscatedName("b")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("k")
   static NodeCache field1155 = new NodeCache(64);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1180630391
   )
   @Export("id")
   public int id;
   @ObfuscatedName("w")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("l")
   public static class227 field1158;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1814878947
   )
   int field1159 = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -53181897
   )
   int field1160 = 128;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -596935029
   )
   int field1161 = 128;
   @ObfuscatedName("x")
   short[] field1162;
   @ObfuscatedName("d")
   short[] field1163;
   @ObfuscatedName("o")
   short[] field1164;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1506554005
   )
   int field1165 = -1;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 2092060125
   )
   public int field1166 = 2000;
   @ObfuscatedName("aj")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1692997811
   )
   int field1168 = -1;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 18137985
   )
   int field1169;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 960577949
   )
   public int field1170 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -163977783
   )
   public int field1171 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -178905569
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("v")
   public static class170 field1173;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1024995375
   )
   public int field1174 = 0;
   @ObfuscatedName("ay")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("ah")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -105297831
   )
   int field1177 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 861342225
   )
   int field1178 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -392949951
   )
   int field1179 = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -561108913
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1835254903
   )
   int field1181 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -2039521679
   )
   int field1182 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1764211963
   )
   int field1183 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -664192451
   )
   public int field1184 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1414922705
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1673435983
   )
   int field1187 = -1;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -493239409
   )
   int field1188 = -1;
   @ObfuscatedName("ap")
   int[] field1189;
   @ObfuscatedName("ak")
   int[] field1190;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -2115138003
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1303086541
   )
   public int field1192 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -986089219
   )
   public int field1193 = 0;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -833627153
   )
   public int field1194 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1872063773
   )
   int field1195 = 128;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -618538631
   )
   public int field1196 = 0;
   @ObfuscatedName("c")
   @Export("itemModelCache")
   static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1251171027
   )
   public int field1198 = 0;
   @ObfuscatedName("ab")
   public boolean field1199 = false;
   @ObfuscatedName("u")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1800440853
   )
   int field1201 = -1;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1695131573
   )
   public int field1202 = -1;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -975905619
   )
   public int field1203 = -1;
   @ObfuscatedName("py")
   static GarbageCollectorMXBean field1205;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1395354749"
   )
   void method1103() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "1243160628"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.field1177;
      int var3 = this.field1178;
      int var4 = this.field1183;
      if(var1) {
         var2 = this.field1168;
         var3 = this.field1181;
         var4 = this.field1153;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!field1173.method3353(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field1173.method3353(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field1173.method3353(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-98"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1169 = var1.method2535();
      } else if(var2 == 2) {
         this.name = var1.method2541();
      } else if(var2 == 4) {
         this.field1166 = var1.method2535();
      } else if(var2 == 5) {
         this.field1184 = var1.method2535();
      } else if(var2 == 6) {
         this.field1174 = var1.method2535();
      } else if(var2 == 7) {
         this.field1170 = var1.method2535();
         if(this.field1170 > 32767) {
            this.field1170 -= 65536;
         }
      } else if(var2 == 8) {
         this.field1171 = var1.method2535();
         if(this.field1171 > 32767) {
            this.field1171 -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.method2538();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.field1177 = var1.method2535();
         this.field1179 = var1.method2656();
      } else if(var2 == 24) {
         this.field1178 = var1.method2535();
      } else if(var2 == 25) {
         this.field1168 = var1.method2535();
         this.field1182 = var1.method2656();
      } else if(var2 == 26) {
         this.field1181 = var1.method2535();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.method2541();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2541();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2656();
            this.field1162 = new short[var3];
            this.field1163 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1162[var4] = (short)var1.method2535();
               this.field1163[var4] = (short)var1.method2535();
            }
         } else if(var2 == 41) {
            var3 = var1.method2656();
            this.field1164 = new short[var3];
            this.field1150 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1164[var4] = (short)var1.method2535();
               this.field1150[var4] = (short)var1.method2535();
            }
         } else if(var2 == 65) {
            this.field1199 = true;
         } else if(var2 == 78) {
            this.field1183 = var1.method2535();
         } else if(var2 == 79) {
            this.field1153 = var1.method2535();
         } else if(var2 == 90) {
            this.maleModel = var1.method2535();
         } else if(var2 == 91) {
            this.field1187 = var1.method2535();
         } else if(var2 == 92) {
            this.field1159 = var1.method2535();
         } else if(var2 == 93) {
            this.field1165 = var1.method2535();
         } else if(var2 == 95) {
            this.field1198 = var1.method2535();
         } else if(var2 == 97) {
            this.note = var1.method2535();
         } else if(var2 == 98) {
            this.field1192 = var1.method2535();
         } else if(var2 >= 100 && var2 < 110) {
            if(null == this.field1189) {
               this.field1189 = new int[10];
               this.field1190 = new int[10];
            }

            this.field1189[var2 - 100] = var1.method2535();
            this.field1190[var2 - 100] = var1.method2535();
         } else if(var2 == 110) {
            this.field1161 = var1.method2535();
         } else if(var2 == 111) {
            this.field1160 = var1.method2535();
         } else if(var2 == 112) {
            this.field1195 = var1.method2535();
         } else if(var2 == 113) {
            this.field1196 = var1.method2534();
         } else if(var2 == 114) {
            this.field1194 = var1.method2534() * 5;
         } else if(var2 == 115) {
            this.field1193 = var1.method2656();
         } else if(var2 == 139) {
            this.field1188 = var1.method2535();
         } else if(var2 == 140) {
            this.field1201 = var1.method2535();
         } else if(var2 == 148) {
            this.field1202 = var1.method2535();
         } else if(var2 == 149) {
            this.field1203 = var1.method2535();
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "25"
   )
   void method1106(ItemComposition var1, ItemComposition var2) {
      this.field1169 = var1.field1169;
      this.field1166 = var1.field1166;
      this.field1184 = var1.field1184;
      this.field1174 = var1.field1174;
      this.field1198 = var1.field1198;
      this.field1170 = var1.field1170;
      this.field1171 = var1.field1171;
      this.field1162 = var1.field1162;
      this.field1163 = var1.field1163;
      this.field1164 = var1.field1164;
      this.field1150 = var1.field1150;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "1694502244"
   )
   void method1107(ItemComposition var1, ItemComposition var2) {
      this.field1169 = var1.field1169;
      this.field1166 = var1.field1166;
      this.field1184 = var1.field1184;
      this.field1174 = var1.field1174;
      this.field1198 = var1.field1198;
      this.field1170 = var1.field1170;
      this.field1171 = var1.field1171;
      this.field1162 = var2.field1162;
      this.field1163 = var2.field1163;
      this.field1164 = var2.field1164;
      this.field1150 = var2.field1150;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.field1177 = var2.field1177;
      this.field1178 = var2.field1178;
      this.field1183 = var2.field1183;
      this.field1168 = var2.field1168;
      this.field1181 = var2.field1181;
      this.field1153 = var2.field1153;
      this.maleModel = var2.maleModel;
      this.field1159 = var2.field1159;
      this.field1187 = var2.field1187;
      this.field1165 = var2.field1165;
      this.field1193 = var2.field1193;
      this.groundActions = var2.groundActions;
      this.inventoryActions = new String[5];
      if(null != var2.inventoryActions) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.inventoryActions[var3] = var2.inventoryActions[var3];
         }
      }

      this.inventoryActions[4] = "Discard";
      this.price = 0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "144738327"
   )
   public final ModelData method1109(int var1) {
      int var3;
      if(this.field1189 != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1190[var3] && this.field1190[var3] != 0) {
               var2 = this.field1189[var3];
            }
         }

         if(var2 != -1) {
            return class45.getItemDefinition(var2).method1109(1);
         }
      }

      ModelData var4 = ModelData.method2236(field1173, this.field1169, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.field1161 != 128 || this.field1160 != 128 || this.field1195 != 128) {
            var4.method2251(this.field1161, this.field1160, this.field1195);
         }

         if(this.field1162 != null) {
            for(var3 = 0; var3 < this.field1162.length; ++var3) {
               var4.method2248(this.field1162[var3], this.field1163[var3]);
            }
         }

         if(this.field1164 != null) {
            for(var3 = 0; var3 < this.field1164.length; ++var3) {
               var4.method2249(this.field1164[var3], this.field1150[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "0"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(this.field1189 != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1190[var3] && this.field1190[var3] != 0) {
               var2 = this.field1189[var3];
            }
         }

         if(var2 != -1) {
            return class45.getItemDefinition(var2).getModel(1);
         }
      }

      Model var6 = (Model)itemModelCache.get((long)this.id);
      if(var6 != null) {
         return var6;
      } else {
         ModelData var5 = ModelData.method2236(field1173, this.field1169, 0);
         if(var5 == null) {
            return null;
         } else {
            if(this.field1161 != 128 || this.field1160 != 128 || this.field1195 != 128) {
               var5.method2251(this.field1161, this.field1160, this.field1195);
            }

            int var4;
            if(this.field1162 != null) {
               for(var4 = 0; var4 < this.field1162.length; ++var4) {
                  var5.method2248(this.field1162[var4], this.field1163[var4]);
               }
            }

            if(null != this.field1164) {
               for(var4 = 0; var4 < this.field1164.length; ++var4) {
                  var5.method2249(this.field1164[var4], this.field1150[var4]);
               }
            }

            var6 = var5.method2256(64 + this.field1196, 768 + this.field1194, -50, -10, -50);
            var6.field1915 = true;
            itemModelCache.put(var6, (long)this.id);
            return var6;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "1254578450"
   )
   public ItemComposition method1111(int var1) {
      if(null != this.field1189 && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1190[var3] && this.field1190[var3] != 0) {
               var2 = this.field1189[var3];
            }
         }

         if(var2 != -1) {
            return class45.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-1392227620"
   )
   static final void method1112(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field286 || (class5.tileSettings[0][var1][var2] & 2) != 0 || (class5.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field79) {
            class5.field79 = var0;
         }

         ObjectComposition var8 = class8.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field936;
            var10 = var8.field937;
         } else {
            var9 = var8.field937;
            var10 = var8.field936;
         }

         int var11;
         int var12;
         if(var1 + var9 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (1 + var9 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (1 + var10 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class5.tileHeights[var0];
         int var16 = var15[var12][var14] + var15[var11][var14] + var15[var12][var13] + var15[var11][var13] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var10 << 6) + (var2 << 7);
         int var19 = 1073741824 + (var3 << 14) + (var2 << 7) + var1;
         if(var8.field958 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = var5 + (var4 << 6);
         if(var8.field961 == 1) {
            var20 += 256;
         }

         if(var8.method836()) {
            class21.method569(var0, var1, var2, var8, var4);
         }

         Object var26;
         if(var5 == 22) {
            if(!Client.field286 || var8.field958 != 0 || var8.field938 == 1 || var8.field931) {
               if(var8.field944 == -1 && null == var8.impostorIds) {
                  var26 = var8.method827(22, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 22, var4, var0, var1, var2, var8.field944, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var26, var19, var20);
               if(var8.field938 == 1 && var7 != null) {
                  var7.method2425(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field944 == -1 && null == var8.impostorIds) {
                     var26 = var8.method827(var5, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                  }

                  var6.method2046(var0, var1, var2, var16, 1, 1, (Renderable)var26, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class32.field715[var0][var1][var2] |= 2340;
                  }

                  if(var8.field938 != 0 && null != var7) {
                     var7.method2413(var1, var2, var9, var10, var8.field967);
                  }

               } else if(var5 == 0) {
                  if(var8.field944 == -1 && null == var8.impostorIds) {
                     var26 = var8.method827(0, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 0, var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                  }

                  var6.method1972(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class5.field86[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field952) {
                        class5.field81[var0][var1][var2] = 50;
                        class5.field81[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field943) {
                        class32.field715[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field952) {
                        class5.field81[var0][var1][var2 + 1] = 50;
                        class5.field81[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if(var8.field943) {
                        class32.field715[var0][var1][1 + var2] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field952) {
                        class5.field81[var0][var1 + 1][var2] = 50;
                        class5.field81[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field943) {
                        class32.field715[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field952) {
                        class5.field81[var0][var1][var2] = 50;
                        class5.field81[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field943) {
                        class32.field715[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field938 != 0 && null != var7) {
                     var7.method2412(var1, var2, var5, var4, var8.field967);
                  }

                  if(var8.field945 != 16) {
                     var6.method2037(var0, var1, var2, var8.field945);
                  }

               } else if(var5 == 1) {
                  if(var8.field944 == -1 && null == var8.impostorIds) {
                     var26 = var8.method827(1, var4, var15, var17, var16, var18);
                  } else {
                     var26 = new class12(var3, 1, var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                  }

                  var6.method1972(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class5.field87[var4], 0, var19, var20);
                  if(var8.field952) {
                     if(var4 == 0) {
                        class5.field81[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        class5.field81[var0][var1 + 1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class5.field81[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class5.field81[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field938 != 0 && var7 != null) {
                     var7.method2412(var1, var2, var5, var4, var8.field967);
                  }

               } else {
                  int var21;
                  Object var23;
                  if(var5 == 2) {
                     var21 = 1 + var4 & 3;
                     Object var29;
                     if(var8.field944 == -1 && var8.impostorIds == null) {
                        var29 = var8.method827(2, 4 + var4, var15, var17, var16, var18);
                        var23 = var8.method827(2, var21, var15, var17, var16, var18);
                     } else {
                        var29 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                        var23 = new class12(var3, 2, var21, var0, var1, var2, var8.field944, true, (Renderable)null);
                     }

                     var6.method1972(var0, var1, var2, var16, (Renderable)var29, (Renderable)var23, class5.field86[var4], class5.field86[var21], var19, var20);
                     if(var8.field943) {
                        if(var4 == 0) {
                           class32.field715[var0][var1][var2] |= 585;
                           class32.field715[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class32.field715[var0][var1][var2 + 1] |= 1170;
                           class32.field715[var0][1 + var1][var2] |= 585;
                        } else if(var4 == 2) {
                           class32.field715[var0][1 + var1][var2] |= 585;
                           class32.field715[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class32.field715[var0][var1][var2] |= 1170;
                           class32.field715[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field938 != 0 && var7 != null) {
                        var7.method2412(var1, var2, var5, var4, var8.field967);
                     }

                     if(var8.field945 != 16) {
                        var6.method2037(var0, var1, var2, var8.field945);
                     }

                  } else if(var5 == 3) {
                     if(var8.field944 == -1 && null == var8.impostorIds) {
                        var26 = var8.method827(3, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 3, var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                     }

                     var6.method1972(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class5.field87[var4], 0, var19, var20);
                     if(var8.field952) {
                        if(var4 == 0) {
                           class5.field81[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class5.field81[var0][1 + var1][1 + var2] = 50;
                        } else if(var4 == 2) {
                           class5.field81[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class5.field81[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field938 != 0 && var7 != null) {
                        var7.method2412(var1, var2, var5, var4, var8.field967);
                     }

                  } else if(var5 == 9) {
                     if(var8.field944 == -1 && null == var8.impostorIds) {
                        var26 = var8.method827(var5, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, var5, var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                     }

                     var6.method2046(var0, var1, var2, var16, 1, 1, (Renderable)var26, 0, var19, var20);
                     if(var8.field938 != 0 && var7 != null) {
                        var7.method2413(var1, var2, var9, var10, var8.field967);
                     }

                     if(var8.field945 != 16) {
                        var6.method2037(var0, var1, var2, var8.field945);
                     }

                  } else if(var5 == 4) {
                     if(var8.field944 == -1 && null == var8.impostorIds) {
                        var26 = var8.method827(4, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                     }

                     var6.method2021(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class5.field86[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var21 = 16;
                     var22 = var6.method2044(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class8.getObjectDefinition(var22 >> 14 & 32767).field945;
                     }

                     if(var8.field944 == -1 && null == var8.impostorIds) {
                        var23 = var8.method827(4, var4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                     }

                     var6.method2021(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, class5.field86[var4], 0, var21 * class5.field85[var4], var21 * class5.field89[var4], var19, var20);
                  } else if(var5 == 6) {
                     var21 = 8;
                     var22 = var6.method2044(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class8.getObjectDefinition(var22 >> 14 & 32767).field945 / 2;
                     }

                     if(var8.field944 == -1 && null == var8.impostorIds) {
                        var23 = var8.method827(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                     }

                     var6.method2021(var0, var1, var2, var16, (Renderable)var23, (Renderable)null, 256, var4, var21 * class5.field98[var4], var21 * class5.field91[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.field944 == -1 && var8.impostorIds == null) {
                        var26 = var8.method827(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, 4 + var22, var0, var1, var2, var8.field944, true, (Renderable)null);
                     }

                     var6.method2021(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var21 = 8;
                     var22 = var6.method2044(var0, var1, var2);
                     if(var22 != 0) {
                        var21 = class8.getObjectDefinition(var22 >> 14 & 32767).field945 / 2;
                     }

                     int var25 = 2 + var4 & 3;
                     Object var24;
                     if(var8.field944 == -1 && null == var8.impostorIds) {
                        var23 = var8.method827(4, 4 + var4, var15, var17, var16, var18);
                        var24 = var8.method827(4, 4 + var25, var15, var17, var16, var18);
                     } else {
                        var23 = new class12(var3, 4, 4 + var4, var0, var1, var2, var8.field944, true, (Renderable)null);
                        var24 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field944, true, (Renderable)null);
                     }

                     var6.method2021(var0, var1, var2, var16, (Renderable)var23, (Renderable)var24, 256, var4, var21 * class5.field98[var4], var21 * class5.field91[var4], var19, var20);
                  }
               }
            } else {
               if(var8.field944 == -1 && null == var8.impostorIds) {
                  var26 = var8.method827(10, var4, var15, var17, var16, var18);
               } else {
                  var26 = new class12(var3, 10, var4, var0, var1, var2, var8.field944, true, (Renderable)null);
               }

               if(null != var26 && var6.method2046(var0, var1, var2, var16, var9, var10, (Renderable)var26, var5 == 11?256:0, var19, var20) && var8.field952) {
                  var22 = 15;
                  if(var26 instanceof Model) {
                     var22 = ((Model)var26).method2324() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var27 = 0; var27 <= var9; ++var27) {
                     for(int var28 = 0; var28 <= var10; ++var28) {
                        if(var22 > class5.field81[var0][var1 + var27][var28 + var2]) {
                           class5.field81[var0][var27 + var1][var2 + var28] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field938 != 0 && var7 != null) {
                  var7.method2413(var1, var2, var9, var10, var8.field967);
               }

            }
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "2120638323"
   )
   public final boolean method1114(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1159;
      if(var1) {
         var2 = this.field1187;
         var3 = this.field1165;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!field1173.method3353(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field1173.method3353(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "-1032734293"
   )
   public final ModelData method1115(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1159;
      if(var1) {
         var2 = this.field1187;
         var3 = this.field1165;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2236(field1173, var2, 0);
         if(var3 != -1) {
            ModelData var7 = ModelData.method2236(field1173, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var7};
            var4 = new ModelData(var6, 2);
         }

         int var5;
         if(null != this.field1162) {
            for(var5 = 0; var5 < this.field1162.length; ++var5) {
               var4.method2248(this.field1162[var5], this.field1163[var5]);
            }
         }

         if(null != this.field1164) {
            for(var5 = 0; var5 < this.field1164.length; ++var5) {
               var4.method2249(this.field1164[var5], this.field1150[var5]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LKitDefinition;",
      garbageValue = "-1234607430"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field1030.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field1041.method3304(3, var0);
         var1 = new KitDefinition();
         if(null != var2) {
            var1.method936(new Buffer(var2));
         }

         KitDefinition.field1030.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "898380689"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.field1177;
      int var3 = this.field1178;
      int var4 = this.field1183;
      if(var1) {
         var2 = this.field1168;
         var3 = this.field1181;
         var4 = this.field1153;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method2236(field1173, var2, 0);
         if(var3 != -1) {
            ModelData var9 = ModelData.method2236(field1173, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2236(field1173, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var9, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var9};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.field1179 != 0) {
            var5.method2247(0, this.field1179, 0);
         }

         if(var1 && this.field1182 != 0) {
            var5.method2247(0, this.field1182, 0);
         }

         int var6;
         if(this.field1162 != null) {
            for(var6 = 0; var6 < this.field1162.length; ++var6) {
               var5.method2248(this.field1162[var6], this.field1163[var6]);
            }
         }

         if(this.field1164 != null) {
            for(var6 = 0; var6 < this.field1164.length; ++var6) {
               var5.method2249(this.field1164[var6], this.field1150[var6]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-2124788256"
   )
   void method1155(ItemComposition var1, ItemComposition var2) {
      this.field1169 = var1.field1169;
      this.field1166 = var1.field1166;
      this.field1184 = var1.field1184;
      this.field1174 = var1.field1174;
      this.field1198 = var1.field1198;
      this.field1170 = var1.field1170;
      this.field1171 = var1.field1171;
      this.field1162 = var1.field1162;
      this.field1163 = var1.field1163;
      this.field1164 = var1.field1164;
      this.field1150 = var1.field1150;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field1199 = false;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "15"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }
}
