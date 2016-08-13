import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bt")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 978178535
   )
   int field1176 = -1;
   @ObfuscatedName("b")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1685935717
   )
   public int field1178 = -1;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 117914055
   )
   public int field1179 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -188249029
   )
   public static int field1180;
   @ObfuscatedName("ac")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("z")
   short[] field1182;
   @ObfuscatedName("w")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 624560095
   )
   @Export("id")
   public int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 636141
   )
   int field1185;
   @ObfuscatedName("u")
   public static NodeCache field1186 = new NodeCache(64);
   @ObfuscatedName("e")
   static class170 field1187;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 554758351
   )
   public int field1188 = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 389970231
   )
   public int field1189 = 0;
   @ObfuscatedName("h")
   static class170 field1190;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 251699853
   )
   public int field1191 = 2000;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -2055578525
   )
   int field1192 = -1;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -801932717
   )
   public int field1193 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 65511609
   )
   public int field1194 = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1119471815
   )
   public int field1195 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1093529073
   )
   public int field1196 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1668957777
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("s")
   @Export("isMembersWorld")
   static boolean isMembersWorld;
   @ObfuscatedName("ad")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("as")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("d")
   short[] field1201;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1043660705
   )
   int field1202 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1625362735
   )
   int field1203 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 554910917
   )
   int field1204 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1006904701
   )
   int field1205 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -516662509
   )
   int field1206 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 105560677
   )
   int field1207 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 148326063
   )
   int field1208 = -1;
   @ObfuscatedName("o")
   short[] field1209;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -583877361
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -893238279
   )
   int field1211 = -1;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1485722379
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 143052985
   )
   public int field1213 = -1;
   @ObfuscatedName("aj")
   int[] field1214;
   @ObfuscatedName("ae")
   int[] field1215;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 38903507
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1984294631
   )
   int field1217 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1101351047
   )
   int field1218 = 128;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -562400687
   )
   int field1219 = 128;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 968252187
   )
   int field1220 = 128;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 437749807
   )
   public int field1221 = 0;
   @ObfuscatedName("n")
   @Export("itemModelCache")
   public static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("f")
   short[] field1223;
   @ObfuscatedName("aa")
   public boolean field1224 = false;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1797894955
   )
   int field1225 = -1;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -401160527
   )
   int field1226 = -1;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -154771703
   )
   public int field1227 = -1;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "123"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.field1202;
      int var3 = this.field1203;
      int var4 = this.field1208;
      if(var1) {
         var2 = this.field1205;
         var3 = this.field1206;
         var4 = this.field1176;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!field1190.method3453(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field1190.method3453(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field1190.method3453(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "548838556"
   )
   void method1172() {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "-85"
   )
   void method1174(ItemComposition var1, ItemComposition var2) {
      this.field1185 = var1.field1185;
      this.field1191 = var1.field1191;
      this.field1188 = var1.field1188;
      this.field1193 = var1.field1193;
      this.field1194 = var1.field1194;
      this.field1179 = var1.field1179;
      this.field1196 = var1.field1196;
      this.field1209 = var1.field1209;
      this.field1201 = var1.field1201;
      this.field1223 = var1.field1223;
      this.field1182 = var1.field1182;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "0"
   )
   void method1175(ItemComposition var1, ItemComposition var2) {
      this.field1185 = var1.field1185;
      this.field1191 = var1.field1191;
      this.field1188 = var1.field1188;
      this.field1193 = var1.field1193;
      this.field1194 = var1.field1194;
      this.field1179 = var1.field1179;
      this.field1196 = var1.field1196;
      this.field1209 = var2.field1209;
      this.field1201 = var2.field1201;
      this.field1223 = var2.field1223;
      this.field1182 = var2.field1182;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.field1202 = var2.field1202;
      this.field1203 = var2.field1203;
      this.field1208 = var2.field1208;
      this.field1205 = var2.field1205;
      this.field1206 = var2.field1206;
      this.field1176 = var2.field1176;
      this.maleModel = var2.maleModel;
      this.field1211 = var2.field1211;
      this.field1192 = var2.field1192;
      this.field1217 = var2.field1217;
      this.field1189 = var2.field1189;
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "1528987545"
   )
   void method1176(ItemComposition var1, ItemComposition var2) {
      this.field1185 = var1.field1185;
      this.field1191 = var1.field1191;
      this.field1188 = var1.field1188;
      this.field1193 = var1.field1193;
      this.field1194 = var1.field1194;
      this.field1179 = var1.field1179;
      this.field1196 = var1.field1196;
      this.field1209 = var1.field1209;
      this.field1201 = var1.field1201;
      this.field1223 = var1.field1223;
      this.field1182 = var1.field1182;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field1224 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "-16"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(this.field1214 != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1215[var3] && this.field1215[var3] != 0) {
               var2 = this.field1214[var3];
            }
         }

         if(var2 != -1) {
            return class1.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2369(field1190, this.field1185, 0);
         if(null == var6) {
            return null;
         } else {
            if(this.field1218 != 128 || this.field1219 != 128 || this.field1220 != 128) {
               var6.method2375(this.field1218, this.field1219, this.field1220);
            }

            int var4;
            if(null != this.field1209) {
               for(var4 = 0; var4 < this.field1209.length; ++var4) {
                  var6.method2305(this.field1209[var4], this.field1201[var4]);
               }
            }

            if(this.field1223 != null) {
               for(var4 = 0; var4 < this.field1223.length; ++var4) {
                  var6.method2306(this.field1223[var4], this.field1182[var4]);
               }
            }

            var5 = var6.method2321(this.field1221 + 64, 768 + this.field1195, -50, -10, -50);
            var5.field1892 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "116"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.field1202;
      int var3 = this.field1203;
      int var4 = this.field1208;
      if(var1) {
         var2 = this.field1205;
         var3 = this.field1206;
         var4 = this.field1176;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method2369(field1190, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2369(field1190, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2369(field1190, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.field1204 != 0) {
            var5.method2304(0, this.field1204, 0);
         }

         if(var1 && this.field1207 != 0) {
            var5.method2304(0, this.field1207, 0);
         }

         int var9;
         if(null != this.field1209) {
            for(var9 = 0; var9 < this.field1209.length; ++var9) {
               var5.method2305(this.field1209[var9], this.field1201[var9]);
            }
         }

         if(null != this.field1223) {
            for(var9 = 0; var9 < this.field1223.length; ++var9) {
               var5.method2306(this.field1223[var9], this.field1182[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   public static void method1182() {
      class79.field1457 = null;
      class180.field2962 = null;
      class192.field3106 = null;
      class79.field1458 = null;
      class79.field1459 = null;
      class145.field2236 = (byte[][])null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "-633158225"
   )
   public final ModelData method1183(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1211;
      if(var1) {
         var2 = this.field1192;
         var3 = this.field1217;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2369(field1190, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2369(field1190, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(this.field1209 != null) {
            for(var7 = 0; var7 < this.field1209.length; ++var7) {
               var4.method2305(this.field1209[var7], this.field1201[var7]);
            }
         }

         if(null != this.field1223) {
            for(var7 = 0; var7 < this.field1223.length; ++var7) {
               var4.method2306(this.field1223[var7], this.field1182[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "1803229497"
   )
   public ItemComposition method1185(int var1) {
      if(this.field1214 != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1215[var3] && this.field1215[var3] != 0) {
               var2 = this.field1214[var3];
            }
         }

         if(var2 != -1) {
            return class1.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "-171588815"
   )
   public final ModelData method1218(int var1) {
      int var2;
      if(null != this.field1214 && var1 > 1) {
         int var3 = -1;

         for(var2 = 0; var2 < 10; ++var2) {
            if(var1 >= this.field1215[var2] && this.field1215[var2] != 0) {
               var3 = this.field1214[var2];
            }
         }

         if(var3 != -1) {
            return class1.getItemDefinition(var3).method1218(1);
         }
      }

      ModelData var4 = ModelData.method2369(field1190, this.field1185, 0);
      if(null == var4) {
         return null;
      } else {
         if(this.field1218 != 128 || this.field1219 != 128 || this.field1220 != 128) {
            var4.method2375(this.field1218, this.field1219, this.field1220);
         }

         if(null != this.field1209) {
            for(var2 = 0; var2 < this.field1209.length; ++var2) {
               var4.method2305(this.field1209[var2], this.field1201[var2]);
            }
         }

         if(null != this.field1223) {
            for(var2 = 0; var2 < this.field1223.length; ++var2) {
               var4.method2306(this.field1223[var2], this.field1182[var2]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-594781665"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.method2633();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "1973113696"
   )
   public final boolean method1232(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1211;
      if(var1) {
         var2 = this.field1192;
         var3 = this.field1217;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!field1190.method3453(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field1190.method3453(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-81"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1185 = var1.method2635();
      } else if(var2 == 2) {
         this.name = var1.method2663();
      } else if(var2 == 4) {
         this.field1191 = var1.method2635();
      } else if(var2 == 5) {
         this.field1188 = var1.method2635();
      } else if(var2 == 6) {
         this.field1193 = var1.method2635();
      } else if(var2 == 7) {
         this.field1179 = var1.method2635();
         if(this.field1179 > 32767) {
            this.field1179 -= 65536;
         }
      } else if(var2 == 8) {
         this.field1196 = var1.method2635();
         if(this.field1196 > 32767) {
            this.field1196 -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.method2620();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.field1202 = var1.method2635();
         this.field1204 = var1.method2633();
      } else if(var2 == 24) {
         this.field1203 = var1.method2635();
      } else if(var2 == 25) {
         this.field1205 = var1.method2635();
         this.field1207 = var1.method2633();
      } else if(var2 == 26) {
         this.field1206 = var1.method2635();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.method2663();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2663();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2633();
            this.field1209 = new short[var3];
            this.field1201 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1209[var4] = (short)var1.method2635();
               this.field1201[var4] = (short)var1.method2635();
            }
         } else if(var2 == 41) {
            var3 = var1.method2633();
            this.field1223 = new short[var3];
            this.field1182 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1223[var4] = (short)var1.method2635();
               this.field1182[var4] = (short)var1.method2635();
            }
         } else if(var2 == 65) {
            this.field1224 = true;
         } else if(var2 == 78) {
            this.field1208 = var1.method2635();
         } else if(var2 == 79) {
            this.field1176 = var1.method2635();
         } else if(var2 == 90) {
            this.maleModel = var1.method2635();
         } else if(var2 == 91) {
            this.field1192 = var1.method2635();
         } else if(var2 == 92) {
            this.field1211 = var1.method2635();
         } else if(var2 == 93) {
            this.field1217 = var1.method2635();
         } else if(var2 == 95) {
            this.field1194 = var1.method2635();
         } else if(var2 == 97) {
            this.note = var1.method2635();
         } else if(var2 == 98) {
            this.field1178 = var1.method2635();
         } else if(var2 >= 100 && var2 < 110) {
            if(this.field1214 == null) {
               this.field1214 = new int[10];
               this.field1215 = new int[10];
            }

            this.field1214[var2 - 100] = var1.method2635();
            this.field1215[var2 - 100] = var1.method2635();
         } else if(var2 == 110) {
            this.field1218 = var1.method2635();
         } else if(var2 == 111) {
            this.field1219 = var1.method2635();
         } else if(var2 == 112) {
            this.field1220 = var1.method2635();
         } else if(var2 == 113) {
            this.field1221 = var1.method2634();
         } else if(var2 == 114) {
            this.field1195 = var1.method2634() * 5;
         } else if(var2 == 115) {
            this.field1189 = var1.method2633();
         } else if(var2 == 139) {
            this.field1225 = var1.method2635();
         } else if(var2 == 140) {
            this.field1226 = var1.method2635();
         } else if(var2 == 148) {
            this.field1227 = var1.method2635();
         } else if(var2 == 149) {
            this.field1213 = var1.method2635();
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-33"
   )
   public static int method1234(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         var2 = (var2 << 5) - var2 + var0.charAt(var3);
      }

      return var2;
   }
}
