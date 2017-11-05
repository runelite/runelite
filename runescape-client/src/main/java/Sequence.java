import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jt")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("seq_ref")
   static IndexDataBase seq_ref;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("skel_ref")
   static IndexDataBase skel_ref;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("skin_ref")
   static IndexDataBase skin_ref;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("sequences")
   static NodeCache sequences;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("skeletons")
   static NodeCache skeletons;
   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field3621;
   @ObfuscatedName("v")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("p")
   int[] field3601;
   @ObfuscatedName("e")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("d")
   public int[] field3609;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 931961033
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("z")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("n")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 480891779
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1083880125
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1313092407
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -693709707
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1727334281
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1463928103
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1283389933
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;B)V",
      garbageValue = "-45"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4803(var1, var2);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfz;IB)V",
      garbageValue = "32"
   )
   void method4803(Buffer var1, int var2) {
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
         this.field3601 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3601[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3601[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3609 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3609[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1150345835"
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Leh;IB)Leh;",
      garbageValue = "11"
   )
   public Model method4779(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class7.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2628(true);
      } else {
         Model var4 = var1.method2628(!var3.method2906(var2));
         var4.method2625(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Leh;IIB)Leh;",
      garbageValue = "-57"
   )
   Model method4782(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = class7.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2628(true);
      } else {
         Model var5 = var1.method2628(!var4.method2906(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2567();
         } else if(var3 == 2) {
            var5.method2566();
         } else if(var3 == 3) {
            var5.method2565();
         }

         var5.method2625(var4, var2);
         if(var3 == 1) {
            var5.method2565();
         } else if(var3 == 2) {
            var5.method2566();
         } else if(var3 == 3) {
            var5.method2567();
         }

         return var5;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Leh;II)Leh;",
      garbageValue = "705374566"
   )
   Model method4783(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = class7.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2629(true);
      } else {
         Model var4 = var1.method2629(!var3.method2906(var2));
         var4.method2625(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Leh;ILjt;II)Leh;",
      garbageValue = "-409956380"
   )
   public Model method4784(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = class7.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method4779(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = class7.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2628(!var5.method2906(var2));
            var7.method2625(var5, var2);
            return var7;
         } else {
            var7 = var1.method2628(!var5.method2906(var2) & !var6.method2906(var4));
            var7.method2563(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Leh;II)Leh;",
      garbageValue = "-1927229108"
   )
   public Model method4785(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = class7.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2628(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3601 != null && var2 < this.field3601.length) {
            var6 = this.field3601[var2];
            var5 = class7.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2628(!var4.method2906(var3) & !var5.method2906(var6));
            var7.method2625(var4, var3);
            var7.method2625(var5, var6);
            return var7;
         } else {
            var7 = var1.method2628(!var4.method2906(var3));
            var7.method2625(var4, var3);
            return var7;
         }
      }
   }
}
