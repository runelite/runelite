import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public class class281 extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field3585;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field3571;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   public static IndexDataBase field3572;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3573;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3584;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static NodeCache field3590;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1917050145
   )
   int field3570;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1426087437
   )
   public int field3579;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 40111167
   )
   public int field3580;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1326844647
   )
   int field3586;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1778479359
   )
   int field3583;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2054585885
   )
   int field3581;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1621925887
   )
   int field3574;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1232706159
   )
   public int field3578;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1677298011
   )
   public int field3589;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 244219909
   )
   public int field3587;
   @ObfuscatedName("f")
   String field3588;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1271285693
   )
   public int field3575;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -795869219
   )
   public int field3582;
   @ObfuscatedName("h")
   public int[] field3591;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -248784553
   )
   int field3592;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1196445205
   )
   int field3593;

   static {
      field3573 = new NodeCache(64);
      field3584 = new NodeCache(64);
      field3590 = new NodeCache(20);
   }

   class281() {
      this.field3570 = -1;
      this.field3579 = 16777215;
      this.field3580 = 70;
      this.field3586 = -1;
      this.field3583 = -1;
      this.field3581 = -1;
      this.field3574 = -1;
      this.field3578 = 0;
      this.field3589 = 0;
      this.field3587 = -1;
      this.field3588 = "";
      this.field3575 = -1;
      this.field3582 = 0;
      this.field3592 = -1;
      this.field3593 = -1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgb;B)V",
      garbageValue = "1"
   )
   void method4952(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4953(var1, var2);
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "-767409302"
   )
   void method4953(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3570 = var1.method3553();
      } else if(var2 == 2) {
         this.field3579 = var1.read24BitInt();
      } else if(var2 == 3) {
         this.field3586 = var1.method3553();
      } else if(var2 == 4) {
         this.field3581 = var1.method3553();
      } else if(var2 == 5) {
         this.field3583 = var1.method3553();
      } else if(var2 == 6) {
         this.field3574 = var1.method3553();
      } else if(var2 == 7) {
         this.field3578 = var1.readShort();
      } else if(var2 == 8) {
         this.field3588 = var1.getJagString();
      } else if(var2 == 9) {
         this.field3580 = var1.readUnsignedShort();
      } else if(var2 == 10) {
         this.field3589 = var1.readShort();
      } else if(var2 == 11) {
         this.field3587 = 0;
      } else if(var2 == 12) {
         this.field3575 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3582 = var1.readShort();
      } else if(var2 == 14) {
         this.field3587 = var1.readUnsignedShort();
      } else if(var2 == 17 || var2 == 18) {
         this.field3592 = var1.readUnsignedShort();
         if(this.field3592 == 65535) {
            this.field3592 = -1;
         }

         this.field3593 = var1.readUnsignedShort();
         if(this.field3593 == 65535) {
            this.field3593 = -1;
         }

         int var3 = -1;
         if(var2 == 18) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.field3591 = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.field3591[var5] = var1.readUnsignedShort();
            if(this.field3591[var5] == 65535) {
               this.field3591[var5] = -1;
            }
         }

         this.field3591[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Ljh;",
      garbageValue = "203983108"
   )
   public final class281 method4973() {
      int var1 = -1;
      if(this.field3592 != -1) {
         var1 = World.getVarbit(this.field3592);
      } else if(this.field3593 != -1) {
         var1 = class237.widgetSettings[this.field3593];
      }

      int var2;
      if(var1 >= 0 && var1 < this.field3591.length - 1) {
         var2 = this.field3591[var1];
      } else {
         var2 = this.field3591[this.field3591.length - 1];
      }

      return var2 != -1?PendingSpawn.method1649(var2):null;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "791025054"
   )
   public String method4978(int var1) {
      String var2 = this.field3588;

      while(true) {
         int var3 = var2.indexOf("%1");
         if(var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + class177.method3421(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "650468659"
   )
   public SpritePixels method4956() {
      if(this.field3586 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3584.get((long)this.field3586);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method1(field3571, this.field3586, 0);
            if(var1 != null) {
               field3584.put(var1, (long)this.field3586);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "382013448"
   )
   public SpritePixels method4957() {
      if(this.field3583 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3584.get((long)this.field3583);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method1(field3571, this.field3583, 0);
            if(var1 != null) {
               field3584.put(var1, (long)this.field3583);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "-504867108"
   )
   public SpritePixels method4958() {
      if(this.field3581 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3584.get((long)this.field3581);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method1(field3571, this.field3581, 0);
            if(var1 != null) {
               field3584.put(var1, (long)this.field3581);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Lla;",
      garbageValue = "-783347820"
   )
   public SpritePixels method4959() {
      if(this.field3574 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)field3584.get((long)this.field3574);
         if(var1 != null) {
            return var1;
         } else {
            var1 = class1.method1(field3571, this.field3574, 0);
            if(var1 != null) {
               field3584.put(var1, (long)this.field3574);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Lkm;",
      garbageValue = "-1469859503"
   )
   public Font method4960() {
      if(this.field3570 == -1) {
         return null;
      } else {
         Font var1 = (Font)field3590.get((long)this.field3570);
         if(var1 != null) {
            return var1;
         } else {
            var1 = AbstractSoundSystem.method2222(field3571, field3572, this.field3570, 0);
            if(var1 != null) {
               field3590.put(var1, (long)this.field3570);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;I)V",
      garbageValue = "-546124216"
   )
   public static void method4954(IndexDataBase var0, IndexDataBase var1) {
      NPCComposition.NpcDefinition_indexCache = var0;
      NPCComposition.NpcDefinition_modelIndexCache = var1;
   }
}
