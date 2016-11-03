import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bg")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1323989599
   )
   public static int field1167;
   @ObfuscatedName("c")
   static class170 field1169;
   @ObfuscatedName("ab")
   public boolean field1170 = false;
   @ObfuscatedName("v")
   @Export("worldList")
   static World[] worldList;
   @ObfuscatedName("y")
   public static NodeCache field1172 = new NodeCache(64);
   @ObfuscatedName("u")
   @Export("itemModelCache")
   public static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("h")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1729631083
   )
   @Export("id")
   public int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -29555343
   )
   int field1176;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1655112617
   )
   public int field1177 = -1;
   @ObfuscatedName("p")
   short[] field1178;
   @ObfuscatedName("s")
   short[] field1179;
   @ObfuscatedName("w")
   short[] field1180;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1814803151
   )
   int field1181 = -1;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -530869403
   )
   public int field1182 = 2000;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1814777267
   )
   public int field1183 = 0;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1404723915
   )
   public int field1184 = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -797795661
   )
   int field1185 = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1078977065
   )
   public int field1186 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1064246197
   )
   public int field1187 = 0;
   @ObfuscatedName("i")
   short[] field1188;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2003711971
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("aq")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("al")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("av")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1377057985
   )
   int field1193 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 740736437
   )
   int field1194 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1384963553
   )
   int field1195 = 0;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -897442787
   )
   public int field1196 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 543181263
   )
   int field1197 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 148246683
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1591833259
   )
   int field1200 = -1;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1464028467
   )
   public int field1201 = 0;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1936917099
   )
   int field1202 = -1;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 633424867
   )
   int field1203 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1891865267
   )
   int field1204 = -1;
   @ObfuscatedName("e")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("ai")
   int[] field1206;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1181180723
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1369705273
   )
   int field1208 = 128;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1215977149
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 139759549
   )
   int field1210 = 128;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1312424263
   )
   int field1211 = 128;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1030833295
   )
   public int field1212 = 0;
   @ObfuscatedName("j")
   @Export("isMembersWorld")
   static boolean isMembersWorld;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1433975935
   )
   public int field1214 = 0;
   @ObfuscatedName("aw")
   int[] field1215;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -824049159
   )
   public int field1216 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1525418883
   )
   public int field1217 = 0;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 1258863063
   )
   int field1218 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1453777919
   )
   int field1219 = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1767301271
   )
   int field1220 = -1;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-36"
   )
   void method1113() {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-790635363"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.method2571();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "742191202"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1176 = var1.method2691();
      } else if(var2 == 2) {
         this.name = var1.method2579();
      } else if(var2 == 4) {
         this.field1182 = var1.method2691();
      } else if(var2 == 5) {
         this.field1183 = var1.method2691();
      } else if(var2 == 6) {
         this.field1184 = var1.method2691();
      } else if(var2 == 7) {
         this.field1186 = var1.method2691();
         if(this.field1186 > 32767) {
            this.field1186 -= 65536;
         }
      } else if(var2 == 8) {
         this.field1187 = var1.method2691();
         if(this.field1187 > 32767) {
            this.field1187 -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.method2576();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.field1193 = var1.method2691();
         this.field1195 = var1.method2571();
      } else if(var2 == 24) {
         this.field1194 = var1.method2691();
      } else if(var2 == 25) {
         this.field1220 = var1.method2691();
         this.field1219 = var1.method2571();
      } else if(var2 == 26) {
         this.field1197 = var1.method2691();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.method2579();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2579();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2571();
            this.field1178 = new short[var3];
            this.field1179 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1178[var4] = (short)var1.method2691();
               this.field1179[var4] = (short)var1.method2691();
            }
         } else if(var2 == 41) {
            var3 = var1.method2571();
            this.field1180 = new short[var3];
            this.field1188 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1180[var4] = (short)var1.method2691();
               this.field1188[var4] = (short)var1.method2691();
            }
         } else if(var2 == 65) {
            this.field1170 = true;
         } else if(var2 == 78) {
            this.field1185 = var1.method2691();
         } else if(var2 == 79) {
            this.field1200 = var1.method2691();
         } else if(var2 == 90) {
            this.maleModel = var1.method2691();
         } else if(var2 == 91) {
            this.field1181 = var1.method2691();
         } else if(var2 == 92) {
            this.field1202 = var1.method2691();
         } else if(var2 == 93) {
            this.field1204 = var1.method2691();
         } else if(var2 == 95) {
            this.field1201 = var1.method2691();
         } else if(var2 == 97) {
            this.note = var1.method2691();
         } else if(var2 == 98) {
            this.field1177 = var1.method2691();
         } else if(var2 >= 100 && var2 < 110) {
            if(null == this.field1215) {
               this.field1215 = new int[10];
               this.field1206 = new int[10];
            }

            this.field1215[var2 - 100] = var1.method2691();
            this.field1206[var2 - 100] = var1.method2691();
         } else if(var2 == 110) {
            this.field1208 = var1.method2691();
         } else if(var2 == 111) {
            this.field1210 = var1.method2691();
         } else if(var2 == 112) {
            this.field1211 = var1.method2691();
         } else if(var2 == 113) {
            this.field1212 = var1.method2572();
         } else if(var2 == 114) {
            this.field1217 = var1.method2572() * 5;
         } else if(var2 == 115) {
            this.field1214 = var1.method2571();
         } else if(var2 == 139) {
            this.field1203 = var1.method2691();
         } else if(var2 == 140) {
            this.field1218 = var1.method2691();
         } else if(var2 == 148) {
            this.field1216 = var1.method2691();
         } else if(var2 == 149) {
            this.field1196 = var1.method2691();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "1883557159"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.field1193;
      int var3 = this.field1194;
      int var4 = this.field1185;
      if(var1) {
         var2 = this.field1220;
         var3 = this.field1197;
         var4 = this.field1200;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method2274(class117.field2027, var2, 0);
         if(var3 != -1) {
            ModelData var9 = ModelData.method2274(class117.field2027, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2274(class117.field2027, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var9, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var9};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.field1195 != 0) {
            var5.method2275(0, this.field1195, 0);
         }

         if(var1 && this.field1219 != 0) {
            var5.method2275(0, this.field1219, 0);
         }

         int var6;
         if(this.field1178 != null) {
            for(var6 = 0; var6 < this.field1178.length; ++var6) {
               var5.method2285(this.field1178[var6], this.field1179[var6]);
            }
         }

         if(this.field1180 != null) {
            for(var6 = 0; var6 < this.field1180.length; ++var6) {
               var5.method2286(this.field1180[var6], this.field1188[var6]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "126"
   )
   void method1117(ItemComposition var1, ItemComposition var2) {
      this.field1176 = var1.field1176;
      this.field1182 = var1.field1182;
      this.field1183 = var1.field1183;
      this.field1184 = var1.field1184;
      this.field1201 = var1.field1201;
      this.field1186 = var1.field1186;
      this.field1187 = var1.field1187;
      this.field1178 = var2.field1178;
      this.field1179 = var2.field1179;
      this.field1180 = var2.field1180;
      this.field1188 = var2.field1188;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.field1193 = var2.field1193;
      this.field1194 = var2.field1194;
      this.field1185 = var2.field1185;
      this.field1220 = var2.field1220;
      this.field1197 = var2.field1197;
      this.field1200 = var2.field1200;
      this.maleModel = var2.maleModel;
      this.field1202 = var2.field1202;
      this.field1181 = var2.field1181;
      this.field1204 = var2.field1204;
      this.field1214 = var2.field1214;
      this.groundActions = var2.groundActions;
      this.inventoryActions = new String[5];
      if(var2.inventoryActions != null) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.inventoryActions[var3] = var2.inventoryActions[var3];
         }
      }

      this.inventoryActions[4] = "Discard";
      this.price = 0;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "1924923191"
   )
   void method1118(ItemComposition var1, ItemComposition var2) {
      this.field1176 = var1.field1176;
      this.field1182 = var1.field1182;
      this.field1183 = var1.field1183;
      this.field1184 = var1.field1184;
      this.field1201 = var1.field1201;
      this.field1186 = var1.field1186;
      this.field1187 = var1.field1187;
      this.field1178 = var1.field1178;
      this.field1179 = var1.field1179;
      this.field1180 = var1.field1180;
      this.field1188 = var1.field1188;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field1170 = false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)LModelData;",
      garbageValue = "16"
   )
   public final ModelData method1119(int var1) {
      int var3;
      if(this.field1215 != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1206[var3] && this.field1206[var3] != 0) {
               var2 = this.field1215[var3];
            }
         }

         if(var2 != -1) {
            return class22.getItemDefinition(var2).method1119(1);
         }
      }

      ModelData var4 = ModelData.method2274(class117.field2027, this.field1176, 0);
      if(null == var4) {
         return null;
      } else {
         if(this.field1208 != 128 || this.field1210 != 128 || this.field1211 != 128) {
            var4.method2340(this.field1208, this.field1210, this.field1211);
         }

         if(this.field1178 != null) {
            for(var3 = 0; var3 < this.field1178.length; ++var3) {
               var4.method2285(this.field1178[var3], this.field1179[var3]);
            }
         }

         if(null != this.field1180) {
            for(var3 = 0; var3 < this.field1180.length; ++var3) {
               var4.method2286(this.field1180[var3], this.field1188[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "17"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(null != this.field1215 && var1 > 1) {
         int var5 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1206[var3] && this.field1206[var3] != 0) {
               var5 = this.field1215[var3];
            }
         }

         if(var5 != -1) {
            return class22.getItemDefinition(var5).getModel(1);
         }
      }

      Model var2 = (Model)itemModelCache.get((long)this.id);
      if(null != var2) {
         return var2;
      } else {
         ModelData var6 = ModelData.method2274(class117.field2027, this.field1176, 0);
         if(null == var6) {
            return null;
         } else {
            if(this.field1208 != 128 || this.field1210 != 128 || this.field1211 != 128) {
               var6.method2340(this.field1208, this.field1210, this.field1211);
            }

            int var4;
            if(null != this.field1178) {
               for(var4 = 0; var4 < this.field1178.length; ++var4) {
                  var6.method2285(this.field1178[var4], this.field1179[var4]);
               }
            }

            if(this.field1180 != null) {
               for(var4 = 0; var4 < this.field1180.length; ++var4) {
                  var6.method2286(this.field1180[var4], this.field1188[var4]);
               }
            }

            var2 = var6.method2293(this.field1212 + 64, this.field1217 + 768, -50, -10, -50);
            var2.field1911 = true;
            itemModelCache.put(var2, (long)this.id);
            return var2;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "1823416397"
   )
   public ItemComposition method1121(int var1) {
      if(this.field1215 != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1206[var3] && this.field1206[var3] != 0) {
               var2 = this.field1215[var3];
            }
         }

         if(var2 != -1) {
            return class22.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "344710965"
   )
   public final boolean method1124(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1202;
      if(var1) {
         var2 = this.field1181;
         var3 = this.field1204;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!class117.field2027.method3282(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class117.field2027.method3282(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "78"
   )
   public final ModelData method1125(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1202;
      if(var1) {
         var2 = this.field1181;
         var3 = this.field1204;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2274(class117.field2027, var2, 0);
         if(var3 != -1) {
            ModelData var7 = ModelData.method2274(class117.field2027, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var7};
            var4 = new ModelData(var6, 2);
         }

         int var5;
         if(this.field1178 != null) {
            for(var5 = 0; var5 < this.field1178.length; ++var5) {
               var4.method2285(this.field1178[var5], this.field1179[var5]);
            }
         }

         if(null != this.field1180) {
            for(var5 = 0; var5 < this.field1180.length; ++var5) {
               var4.method2286(this.field1180[var5], this.field1188[var5]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "36"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.field1193;
      int var3 = this.field1194;
      int var4 = this.field1185;
      if(var1) {
         var2 = this.field1220;
         var3 = this.field1197;
         var4 = this.field1200;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!class117.field2027.method3282(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class117.field2027.method3282(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class117.field2027.method3282(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-1916872219"
   )
   void method1159(ItemComposition var1, ItemComposition var2) {
      this.field1176 = var1.field1176;
      this.field1182 = var1.field1182;
      this.field1183 = var1.field1183;
      this.field1184 = var1.field1184;
      this.field1201 = var1.field1201;
      this.field1186 = var1.field1186;
      this.field1187 = var1.field1187;
      this.field1178 = var1.field1178;
      this.field1179 = var1.field1179;
      this.field1180 = var1.field1180;
      this.field1188 = var1.field1188;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "1231502540"
   )
   static final void method1162(class125 var0) {
      var0.method2806();
      int var1 = Client.localInteractingIndex;
      Player var2 = class165.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field51 = var1;
      int var3 = var0.method2807(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class47.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method18() << 6);
      var2.pathY[0] = var6 - class21.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method18() << 6);
      class145.plane = var2.field55 = var4;
      if(class34.field771[var1] != null) {
         var2.method11(class34.field771[var1]);
      }

      class34.field777 = 0;
      class34.field773[++class34.field777 - 1] = var1;
      class34.field769[var1] = 0;
      class34.field780 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2807(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class34.field776[var7] = (var9 << 28) + (var10 << 14) + var11;
            class34.field772[var7] = 0;
            class34.field778[var7] = -1;
            class34.field775[++class34.field780 - 1] = var7;
            class34.field769[var7] = 0;
         }
      }

      var0.method2827();
   }

   @ObfuscatedName("eg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "650823935"
   )
   static void method1163(String var0) {
      Client.field285 = var0;

      try {
         String var1 = Client.field480.getParameter(class193.field3114.field3113);
         String var2 = Client.field480.getParameter(class193.field3106.field3113);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = class169.method3276() + 94608000000L;
            class114.field2012.setTime(new Date(var6));
            int var8 = class114.field2012.get(7);
            int var9 = class114.field2012.get(5);
            int var10 = class114.field2012.get(2);
            int var11 = class114.field2012.get(1);
            int var12 = class114.field2012.get(11);
            int var13 = class114.field2012.get(12);
            int var14 = class114.field2012.get(13);
            var5 = class114.field2013[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class114.field2014[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         Client var16 = Client.field480;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }
}
