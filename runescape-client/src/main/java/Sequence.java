import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("qb")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   static MachineInfo field3651;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("skel_ref")
   static IndexDataBase skel_ref;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("skin_ref")
   static IndexDataBase skin_ref;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("f")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("u")
   int[] field3654;
   @ObfuscatedName("t")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("k")
   public int[] field3656;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1516775293
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("d")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("o")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 167069113
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1016799931
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1335951841
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1626220813
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -658657135
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1838348503
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -224484207
   )
   @Export("replyMode")
   public int replyMode;

   static {
      sequences = new NodeCache(64);
      skeletons = new NodeCache(100);
   }

   Sequence() {
      this.frameStep = -1;
      this.stretches = false;
      this.forcedPriority = 5;
      this.leftHandItem = -1;
      this.rightHandItem = -1;
      this.maxLoops = 99;
      this.precedenceAnimating = -1;
      this.priority = -1;
      this.replyMode = 2;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "1752422102"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4710(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "-1928528725"
   )
   void method4710(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedShort();
         this.frameLenghts = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameLenghts[var4] = var1.readUnsignedShort();
         }

         this.frameIDs = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.frameIDs[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 2) {
         this.frameStep = var1.readUnsignedShort();
      } else if(var2 == 3) {
         var3 = var1.readUnsignedByte();
         this.interleaveLeave = new int[var3 + 1];

         for(var4 = 0; var4 < var3; ++var4) {
            this.interleaveLeave[var4] = var1.readUnsignedByte();
         }

         this.interleaveLeave[var3] = 9999999;
      } else if(var2 == 4) {
         this.stretches = true;
      } else if(var2 == 5) {
         this.forcedPriority = var1.readUnsignedByte();
      } else if(var2 == 6) {
         this.leftHandItem = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.rightHandItem = var1.readUnsignedShort();
      } else if(var2 == 8) {
         this.maxLoops = var1.readUnsignedByte();
      } else if(var2 == 9) {
         this.precedenceAnimating = var1.readUnsignedByte();
      } else if(var2 == 10) {
         this.priority = var1.readUnsignedByte();
      } else if(var2 == 11) {
         this.replyMode = var1.readUnsignedByte();
      } else if(var2 == 12) {
         var3 = var1.readUnsignedByte();
         this.field3654 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3654[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3654[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3656 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3656[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2070907910"
   )
   @Export("post")
   void post() {
      if(this.precedenceAnimating == -1) {
         if(this.interleaveLeave != null) {
            this.precedenceAnimating = 2;
         } else {
            this.precedenceAnimating = 0;
         }
      }

      if(this.priority == -1) {
         if(this.interleaveLeave != null) {
            this.priority = 2;
         } else {
            this.priority = 0;
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lev;II)Lev;",
      garbageValue = "-578525524"
   )
   public Model method4699(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class20.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2567(true);
      } else {
         Model var4 = var1.method2567(!var3.method2874(var2));
         var4.method2537(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lev;III)Lev;",
      garbageValue = "294101121"
   )
   Model method4702(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class20.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2567(true);
      } else {
         Model var5 = var1.method2567(!var4.method2874(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2577();
         } else if(var3 == 2) {
            var5.method2519();
         } else if(var3 == 3) {
            var5.method2518();
         }

         var5.method2537(var4, var2);
         if(var3 == 1) {
            var5.method2518();
         } else if(var3 == 2) {
            var5.method2519();
         } else if(var3 == 3) {
            var5.method2577();
         }

         return var5;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lev;II)Lev;",
      garbageValue = "1990718891"
   )
   Model method4703(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class20.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2512(true);
      } else {
         Model var4 = var1.method2512(!var3.method2874(var2));
         var4.method2537(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lev;ILjh;IB)Lev;",
      garbageValue = "-14"
   )
   public Model method4704(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class20.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method4699(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class20.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2567(!var5.method2874(var2));
            var7.method2537(var5, var2);
            return var7;
         } else {
            var7 = var1.method2567(!var5.method2874(var2) & !var6.method2874(var4));
            var7.method2516(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lev;IB)Lev;",
      garbageValue = "5"
   )
   public Model method4698(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class20.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2567(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3654 != null && var2 < this.field3654.length) {
            var6 = this.field3654[var2];
            var5 = class20.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2567(!var4.method2874(var3) & !var5.method2874(var6));
            var7.method2537(var4, var3);
            var7.method2537(var5, var6);
            return var7;
         } else {
            var7 = var1.method2567(!var4.method2874(var3));
            var7.method2537(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lij;III)Z",
      garbageValue = "-788201372"
   )
   static boolean method4738(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         PendingSpawn.decodeSprite(var3);
         return true;
      }
   }
}
