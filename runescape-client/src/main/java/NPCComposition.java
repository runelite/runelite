import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static IndexDataBase field3610;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   static IndexDataBase field3601;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -677646855
   )
   @Export("id")
   public int id;
   @ObfuscatedName("f")
   @Export("name")
   public String name;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -554388201
   )
   public int field3606;
   @ObfuscatedName("t")
   @Export("models")
   int[] models;
   @ObfuscatedName("k")
   int[] field3608;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1906542477
   )
   public int field3609;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1808251415
   )
   public int field3629;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 998782881
   )
   public int field3633;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 928915419
   )
   public int field3624;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 27459151
   )
   public int field3603;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -306271545
   )
   public int field3614;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -679826891
   )
   public int field3622;
   @ObfuscatedName("h")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("c")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("y")
   short[] field3618;
   @ObfuscatedName("p")
   short[] field3619;
   @ObfuscatedName("i")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("l")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2014022581
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1288609973
   )
   int field3623;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -420936823
   )
   int field3631;
   @ObfuscatedName("w")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1980147751
   )
   int field3626;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 479698971
   )
   int field3627;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1691303595
   )
   public int field3628;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1421308837
   )
   public int field3616;
   @ObfuscatedName("aq")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1783305543
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 2092382365
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("ar")
   public boolean field3611;
   @ObfuscatedName("ao")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("at")
   public boolean field3635;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   IterableHashTable field3636;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3606 = 1;
      this.field3609 = -1;
      this.field3629 = -1;
      this.field3633 = -1;
      this.field3624 = -1;
      this.field3603 = -1;
      this.field3614 = -1;
      this.field3622 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3623 = 128;
      this.field3631 = 128;
      this.isVisible = false;
      this.field3626 = 0;
      this.field3627 = 0;
      this.field3628 = -1;
      this.field3616 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3611 = true;
      this.isClickable = true;
      this.field3635 = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1472104874"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfs;S)V",
      garbageValue = "-18406"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4635(var1, var2);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfs;IB)V",
      garbageValue = "8"
   )
   void method4635(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 12) {
         this.field3606 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3609 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3624 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3629 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3633 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3624 = var1.readUnsignedShort();
         this.field3603 = var1.readUnsignedShort();
         this.field3614 = var1.readUnsignedShort();
         this.field3622 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.colors = new short[var3];
         this.modifiedColors = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.colors[var4] = (short)var1.readUnsignedShort();
            this.modifiedColors[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3618 = new short[var3];
         this.field3619 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3618[var4] = (short)var1.readUnsignedShort();
            this.field3619[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3608 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3608[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3623 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3631 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3626 = var1.readByte();
      } else if(var2 == 101) {
         this.field3627 = var1.readByte();
      } else if(var2 == 102) {
         this.field3628 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3616 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3611 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3635 = true;
         } else if(var2 == 249) {
            this.field3636 = class27.method203(var1, this.field3636);
         }
      } else {
         this.varpIndex = var1.readUnsignedShort();
         if(this.varpIndex == 65535) {
            this.varpIndex = -1;
         }

         this.varp32Index = var1.readUnsignedShort();
         if(this.varp32Index == 65535) {
            this.varp32Index = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == 65535) {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljh;ILjh;IB)Lev;",
      garbageValue = "8"
   )
   public final Model method4636(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4636(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3601.method4157(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2419(field3601, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.colors != null) {
               for(var9 = 0; var9 < this.colors.length; ++var9) {
                  var11.recolor(this.colors[var9], this.modifiedColors[var9]);
               }
            }

            if(this.field3618 != null) {
               for(var9 = 0; var9 < this.field3618.length; ++var9) {
                  var11.method2432(this.field3618[var9], this.field3619[var9]);
               }
            }

            var5 = var11.light(this.field3626 + 64, this.field3627 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4704(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4699(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4699(var5, var4);
         } else {
            var10 = var5.method2567(true);
         }

         if(this.field3623 != 128 || this.field3631 != 128) {
            var10.method2505(this.field3623, this.field3631, this.field3623);
         }

         return var10;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Lda;",
      garbageValue = "-374487104"
   )
   public final ModelData method4637() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4637();
      } else if(this.field3608 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3608.length; ++var2) {
            if(!field3601.method4157(this.field3608[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3608.length];

            for(int var3 = 0; var3 < this.field3608.length; ++var3) {
               var6[var3] = ModelData.method2419(field3601, this.field3608[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.colors != null) {
               for(var4 = 0; var4 < this.colors.length; ++var4) {
                  var7.recolor(this.colors[var4], this.modifiedColors[var4]);
               }
            }

            if(this.field3618 != null) {
               for(var4 = 0; var4 < this.field3618.length; ++var4) {
                  var7.method2432(this.field3618[var4], this.field3619[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ljc;",
      garbageValue = "1685104736"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class18.method131(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class218.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class211.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-12"
   )
   public boolean method4639() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class18.method131(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class218.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1373658430"
   )
   public int method4668(int var1, int var2) {
      return CombatInfo2.method4400(this.field3636, var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1401360475"
   )
   public String method4641(int var1, String var2) {
      return ChatLineBuffer.method1852(this.field3636, var1, var2);
   }
}
