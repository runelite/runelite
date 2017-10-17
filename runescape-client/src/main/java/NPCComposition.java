import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3554;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3555;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   IterableHashTable field3572;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 87640709
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ad")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("s")
   @Export("name")
   public String name;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1144180095
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("v")
   int[] field3561;
   @ObfuscatedName("g")
   @Export("models")
   int[] models;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -416969063
   )
   @Export("id")
   public int id;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 231375093
   )
   public int field3559;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -2068387423
   )
   public int field3557;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1717551697
   )
   public int field3565;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -396804821
   )
   public int field3566;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1036550109
   )
   public int field3564;
   @ObfuscatedName("a")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1640441831
   )
   int field3553;
   @ObfuscatedName("j")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("z")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1130130759
   )
   int field3577;
   @ObfuscatedName("c")
   short[] field3571;
   @ObfuscatedName("x")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -43746315
   )
   public int field3581;
   @ObfuscatedName("h")
   short[] field3575;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -329004773
   )
   public int field3567;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1897543249
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("m")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 10065221
   )
   public int field3568;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1787709941
   )
   int field3579;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 697276271
   )
   int field3580;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -857611611
   )
   public int field3584;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 974569827
   )
   public int field3582;
   @ObfuscatedName("af")
   public boolean field3586;
   @ObfuscatedName("aq")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("am")
   public boolean field3588;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3559 = 1;
      this.field3557 = -1;
      this.field3566 = -1;
      this.field3564 = -1;
      this.field3565 = -1;
      this.field3581 = -1;
      this.field3567 = -1;
      this.field3568 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3553 = 128;
      this.field3577 = 128;
      this.isVisible = false;
      this.field3579 = 0;
      this.field3580 = 0;
      this.field3584 = -1;
      this.field3582 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3586 = true;
      this.isClickable = true;
      this.field3588 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lid;",
      garbageValue = "-1720443561"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class88.method1777(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class211.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class72.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "1424307046"
   )
   void method4732(Buffer var1, int var2) {
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
         this.field3559 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3557 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3565 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3566 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3564 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3565 = var1.readUnsignedShort();
         this.field3581 = var1.readUnsignedShort();
         this.field3567 = var1.readUnsignedShort();
         this.field3568 = var1.readUnsignedShort();
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
         this.field3571 = new short[var3];
         this.field3575 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3571[var4] = (short)var1.readUnsignedShort();
            this.field3575[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3561 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3561[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3553 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3577 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3579 = var1.readByte();
      } else if(var2 == 101) {
         this.field3580 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3584 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3582 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3586 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3588 = true;
         } else if(var2 == 249) {
            this.field3572 = class41.method590(var1, this.field3572);
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)Ldl;",
      garbageValue = "-54"
   )
   public final ModelData method4744() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4744();
      } else if(this.field3561 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3561.length; ++var2) {
            if(!field3554.method4237(this.field3561[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3561.length];

            for(int var3 = 0; var3 < this.field3561.length; ++var3) {
               var6[var3] = ModelData.method2498(field3554, this.field3561[var3], 0);
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

            if(this.field3571 != null) {
               for(var4 = 0; var4 < this.field3571.length; ++var4) {
                  var7.method2513(this.field3571[var4], this.field3575[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljl;ILjl;IB)Leb;",
      garbageValue = "0"
   )
   public final Model method4727(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4727(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3554.method4237(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2498(field3554, this.models[var9], 0);
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

            if(this.field3571 != null) {
               for(var9 = 0; var9 < this.field3571.length; ++var9) {
                  var11.method2513(this.field3571[var9], this.field3575[var9]);
               }
            }

            var5 = var11.light(this.field3579 + 64, this.field3580 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4779(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4799(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4799(var5, var4);
         } else {
            var10 = var5.method2641(true);
         }

         if(this.field3553 != 128 || this.field3577 != 128) {
            var10.method2606(this.field3553, this.field3577, this.field3553);
         }

         return var10;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-529421510"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "-761885619"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4732(var1, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1902356819"
   )
   public boolean method4730() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class88.method1777(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class211.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-96"
   )
   public int method4731(int var1, int var2) {
      return FileSystem.method4214(this.field3572, var1, var2);
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-106"
   )
   public String method4742(int var1, String var2) {
      return class85.method1769(this.field3572, var1, var2);
   }
}
