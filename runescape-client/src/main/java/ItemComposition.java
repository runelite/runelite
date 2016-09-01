import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -1029805267
   )
   int field1154 = -1;
   @ObfuscatedName("t")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -279713627
   )
   public int field1158 = 0;
   @ObfuscatedName("m")
   static NodeCache field1159 = new NodeCache(64);
   @ObfuscatedName("p")
   @Export("itemModelCache")
   static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("f")
   @Export("itemSpriteCache")
   static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1524404335
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 855026661
   )
   int field1163 = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1897618099
   )
   int field1164 = -1;
   @ObfuscatedName("h")
   short[] field1165;
   @ObfuscatedName("s")
   short[] field1166;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1833659115
   )
   public int field1167 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 34379001
   )
   public int field1168 = 0;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1760215723
   )
   public int field1169 = 2000;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -386291587
   )
   public int field1170 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -50768407
   )
   public int field1171 = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -820720245
   )
   int field1172 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -429522125
   )
   int field1174 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1462051437
   )
   int field1175 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1219674359
   )
   int field1176 = -1;
   @ObfuscatedName("ah")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("an")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -2117937891
   )
   int field1179 = 128;
   @ObfuscatedName("in")
   static Widget field1180;
   @ObfuscatedName("g")
   short[] field1181;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1480795709
   )
   int field1182;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1387082351
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1726751201
   )
   int field1184 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -632698045
   )
   int field1185 = 0;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 327419041
   )
   int field1186 = -1;
   @ObfuscatedName("ag")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1354437083
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("b")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -2132868535
   )
   int field1190 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1594350187
   )
   int field1191 = -1;
   @ObfuscatedName("am")
   int[] field1192;
   @ObfuscatedName("ac")
   int[] field1193;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1041153655
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 666546009
   )
   public int field1195 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1977109075
   )
   int field1196 = 128;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1121046113
   )
   int field1197 = 128;
   @ObfuscatedName("z")
   public static class170 field1198;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1968509395
   )
   public int field1199 = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -460468299
   )
   public int field1200 = 0;
   @ObfuscatedName("u")
   short[] field1201;
   @ObfuscatedName("ae")
   public boolean field1202 = false;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1254527751
   )
   public int field1203 = 0;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = 1794063975
   )
   int field1204 = -1;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -259377835
   )
   public int field1205 = -1;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 178858999
   )
   public int field1206 = -1;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1912334201
   )
   @Export("isStackable")
   public int isStackable = 0;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   void method1099() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-11807145"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.method2556();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-90"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1182 = var1.method2551();
      } else if(var2 == 2) {
         this.name = var1.method2774();
      } else if(var2 == 4) {
         this.field1169 = var1.method2551();
      } else if(var2 == 5) {
         this.field1167 = var1.method2551();
      } else if(var2 == 6) {
         this.field1171 = var1.method2551();
      } else if(var2 == 7) {
         this.field1158 = var1.method2551();
         if(this.field1158 > 32767) {
            this.field1158 -= 65536;
         }
      } else if(var2 == 8) {
         this.field1168 = var1.method2551();
         if(this.field1168 > 32767) {
            this.field1168 -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.method2561();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.field1164 = var1.method2551();
         this.field1163 = var1.method2556();
      } else if(var2 == 24) {
         this.field1176 = var1.method2551();
      } else if(var2 == 25) {
         this.field1174 = var1.method2551();
         this.field1185 = var1.method2556();
      } else if(var2 == 26) {
         this.field1184 = var1.method2551();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.method2774();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2774();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2556();
            this.field1181 = new short[var3];
            this.field1166 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1181[var4] = (short)var1.method2551();
               this.field1166[var4] = (short)var1.method2551();
            }
         } else if(var2 == 41) {
            var3 = var1.method2556();
            this.field1165 = new short[var3];
            this.field1201 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1165[var4] = (short)var1.method2551();
               this.field1201[var4] = (short)var1.method2551();
            }
         } else if(var2 == 65) {
            this.field1202 = true;
         } else if(var2 == 78) {
            this.field1186 = var1.method2551();
         } else if(var2 == 79) {
            this.field1172 = var1.method2551();
         } else if(var2 == 90) {
            this.maleModel = var1.method2551();
         } else if(var2 == 91) {
            this.field1190 = var1.method2551();
         } else if(var2 == 92) {
            this.field1175 = var1.method2551();
         } else if(var2 == 93) {
            this.field1191 = var1.method2551();
         } else if(var2 == 95) {
            this.field1203 = var1.method2551();
         } else if(var2 == 97) {
            this.note = var1.method2551();
         } else if(var2 == 98) {
            this.field1195 = var1.method2551();
         } else if(var2 >= 100 && var2 < 110) {
            if(this.field1192 == null) {
               this.field1192 = new int[10];
               this.field1193 = new int[10];
            }

            this.field1192[var2 - 100] = var1.method2551();
            this.field1193[var2 - 100] = var1.method2551();
         } else if(var2 == 110) {
            this.field1196 = var1.method2551();
         } else if(var2 == 111) {
            this.field1197 = var1.method2551();
         } else if(var2 == 112) {
            this.field1179 = var1.method2551();
         } else if(var2 == 113) {
            this.field1199 = var1.method2557();
         } else if(var2 == 114) {
            this.field1170 = var1.method2557() * 5;
         } else if(var2 == 115) {
            this.field1200 = var1.method2556();
         } else if(var2 == 139) {
            this.field1154 = var1.method2551();
         } else if(var2 == 140) {
            this.field1204 = var1.method2551();
         } else if(var2 == 148) {
            this.field1205 = var1.method2551();
         } else if(var2 == 149) {
            this.field1206 = var1.method2551();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-1986831084"
   )
   void method1102(ItemComposition var1, ItemComposition var2) {
      this.field1182 = var1.field1182;
      this.field1169 = var1.field1169;
      this.field1167 = var1.field1167;
      this.field1171 = var1.field1171;
      this.field1203 = var1.field1203;
      this.field1158 = var1.field1158;
      this.field1168 = var1.field1168;
      this.field1181 = var1.field1181;
      this.field1166 = var1.field1166;
      this.field1165 = var1.field1165;
      this.field1201 = var1.field1201;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "88974486"
   )
   void method1103(ItemComposition var1, ItemComposition var2) {
      this.field1182 = var1.field1182;
      this.field1169 = var1.field1169;
      this.field1167 = var1.field1167;
      this.field1171 = var1.field1171;
      this.field1203 = var1.field1203;
      this.field1158 = var1.field1158;
      this.field1168 = var1.field1168;
      this.field1181 = var2.field1181;
      this.field1166 = var2.field1166;
      this.field1165 = var2.field1165;
      this.field1201 = var2.field1201;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.field1164 = var2.field1164;
      this.field1176 = var2.field1176;
      this.field1186 = var2.field1186;
      this.field1174 = var2.field1174;
      this.field1184 = var2.field1184;
      this.field1172 = var2.field1172;
      this.maleModel = var2.maleModel;
      this.field1175 = var2.field1175;
      this.field1190 = var2.field1190;
      this.field1191 = var2.field1191;
      this.field1200 = var2.field1200;
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "1301914987"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.field1164;
      int var3 = this.field1176;
      int var4 = this.field1186;
      if(var1) {
         var2 = this.field1174;
         var3 = this.field1184;
         var4 = this.field1172;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method2262(class11.field169, var2, 0);
         if(var3 != -1) {
            ModelData var9 = ModelData.method2262(class11.field169, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2262(class11.field169, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var9, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var9};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.field1163 != 0) {
            var5.method2284(0, this.field1163, 0);
         }

         if(var1 && this.field1185 != 0) {
            var5.method2284(0, this.field1185, 0);
         }

         int var6;
         if(this.field1181 != null) {
            for(var6 = 0; var6 < this.field1181.length; ++var6) {
               var5.method2337(this.field1181[var6], this.field1166[var6]);
            }
         }

         if(this.field1165 != null) {
            for(var6 = 0; var6 < this.field1165.length; ++var6) {
               var5.method2276(this.field1165[var6], this.field1201[var6]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "-107"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.field1164;
      int var3 = this.field1176;
      int var4 = this.field1186;
      if(var1) {
         var2 = this.field1174;
         var3 = this.field1184;
         var4 = this.field1172;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!class11.field169.method3292(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class11.field169.method3292(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class11.field169.method3292(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1207075776"
   )
   public final boolean method1110(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1175;
      if(var1) {
         var2 = this.field1190;
         var3 = this.field1191;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!class11.field169.method3292(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class11.field169.method3292(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "-1129115971"
   )
   public final ModelData method1111(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1175;
      if(var1) {
         var2 = this.field1190;
         var3 = this.field1191;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2262(class11.field169, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2262(class11.field169, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(this.field1181 != null) {
            for(var7 = 0; var7 < this.field1181.length; ++var7) {
               var4.method2337(this.field1181[var7], this.field1166[var7]);
            }
         }

         if(this.field1165 != null) {
            for(var7 = 0; var7 < this.field1165.length; ++var7) {
               var4.method2276(this.field1165[var7], this.field1201[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "984750877"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(null != this.field1192 && var1 > 1) {
         int var5 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1193[var3] && this.field1193[var3] != 0) {
               var5 = this.field1192[var3];
            }
         }

         if(var5 != -1) {
            return MessageNode.getItemDefinition(var5).getModel(1);
         }
      }

      Model var2 = (Model)itemModelCache.get((long)this.id);
      if(null != var2) {
         return var2;
      } else {
         ModelData var6 = ModelData.method2262(class11.field169, this.field1182, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.field1196 != 128 || this.field1197 != 128 || this.field1179 != 128) {
               var6.method2286(this.field1196, this.field1197, this.field1179);
            }

            int var4;
            if(this.field1181 != null) {
               for(var4 = 0; var4 < this.field1181.length; ++var4) {
                  var6.method2337(this.field1181[var4], this.field1166[var4]);
               }
            }

            if(this.field1165 != null) {
               for(var4 = 0; var4 < this.field1165.length; ++var4) {
                  var6.method2276(this.field1165[var4], this.field1201[var4]);
               }
            }

            var2 = var6.method2290(64 + this.field1199, 768 + this.field1170, -50, -10, -50);
            var2.field1866 = true;
            itemModelCache.put(var2, (long)this.id);
            return var2;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "-584445306"
   )
   public final ModelData method1148(int var1) {
      int var3;
      if(this.field1192 != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1193[var3] && this.field1193[var3] != 0) {
               var2 = this.field1192[var3];
            }
         }

         if(var2 != -1) {
            return MessageNode.getItemDefinition(var2).method1148(1);
         }
      }

      ModelData var4 = ModelData.method2262(class11.field169, this.field1182, 0);
      if(null == var4) {
         return null;
      } else {
         if(this.field1196 != 128 || this.field1197 != 128 || this.field1179 != 128) {
            var4.method2286(this.field1196, this.field1197, this.field1179);
         }

         if(null != this.field1181) {
            for(var3 = 0; var3 < this.field1181.length; ++var3) {
               var4.method2337(this.field1181[var3], this.field1166[var3]);
            }
         }

         if(this.field1165 != null) {
            for(var3 = 0; var3 < this.field1165.length; ++var3) {
               var4.method2276(this.field1165[var3], this.field1201[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-1856392767"
   )
   void method1155(ItemComposition var1, ItemComposition var2) {
      this.field1182 = var1.field1182;
      this.field1169 = var1.field1169;
      this.field1167 = var1.field1167;
      this.field1171 = var1.field1171;
      this.field1203 = var1.field1203;
      this.field1158 = var1.field1158;
      this.field1168 = var1.field1168;
      this.field1181 = var1.field1181;
      this.field1166 = var1.field1166;
      this.field1165 = var1.field1165;
      this.field1201 = var1.field1201;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field1202 = false;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-491486018"
   )
   public ItemComposition method1157(int var1) {
      if(null != this.field1192 && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1193[var3] && this.field1193[var3] != 0) {
               var2 = this.field1192[var3];
            }
         }

         if(var2 != -1) {
            return MessageNode.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(LActor;IB)V",
      garbageValue = "16"
   )
   static final void method1163(Actor var0, int var1) {
      class179.method3480(var0.x, var0.y, var1);
   }
}
