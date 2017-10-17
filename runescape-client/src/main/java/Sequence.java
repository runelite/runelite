import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("Sequence")
public class Sequence extends CacheableNode {
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("skeletons")
   public static NodeCache skeletons;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("sequences")
   public static NodeCache sequences;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("skel_ref")
   public static IndexDataBase skel_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("skin_ref")
   public static IndexDataBase skin_ref;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("seq_ref")
   public static IndexDataBase seq_ref;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1089498503
   )
   @Export("precedenceAnimating")
   public int precedenceAnimating;
   @ObfuscatedName("s")
   @Export("frameIDs")
   public int[] frameIDs;
   @ObfuscatedName("y")
   @Export("interleaveLeave")
   int[] interleaveLeave;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 344532397
   )
   @Export("priority")
   public int priority;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1911229311
   )
   @Export("frameStep")
   public int frameStep;
   @ObfuscatedName("g")
   @Export("frameLenghts")
   public int[] frameLenghts;
   @ObfuscatedName("o")
   @Export("stretches")
   public boolean stretches;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -378746125
   )
   @Export("leftHandItem")
   public int leftHandItem;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1448712897
   )
   @Export("forcedPriority")
   public int forcedPriority;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1848224667
   )
   @Export("rightHandItem")
   public int rightHandItem;
   @ObfuscatedName("r")
   int[] field3609;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1460258893
   )
   @Export("maxLoops")
   public int maxLoops;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 935243205
   )
   @Export("replyMode")
   public int replyMode;
   @ObfuscatedName("v")
   public int[] field3613;

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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "-239383745"
   )
   void method4781(Buffer var1, int var2) {
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
         this.field3609 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3609[var4] = var1.readUnsignedShort();
         }

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3609[var4] += var1.readUnsignedShort() << 16;
         }
      } else if(var2 == 13) {
         var3 = var1.readUnsignedByte();
         this.field3613 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3613[var4] = var1.read24BitInt();
         }
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Leb;II)Leb;",
      garbageValue = "1530427899"
   )
   public Model method4799(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = GraphicsObject.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2641(true);
      } else {
         Model var4 = var1.method2641(!var3.method2941(var2));
         var4.method2639(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Leb;ILjl;II)Leb;",
      garbageValue = "-2129695534"
   )
   public Model method4779(Model var1, int var2, Sequence var3, int var4) {
      var2 = this.frameIDs[var2];
      Frames var5 = GraphicsObject.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var5 == null) {
         return var3.method4799(var1, var4);
      } else {
         var4 = var3.frameIDs[var4];
         Frames var6 = GraphicsObject.getFrames(var4 >> 16);
         var4 &= 65535;
         Model var7;
         if(var6 == null) {
            var7 = var1.method2641(!var5.method2941(var2));
            var7.method2639(var5, var2);
            return var7;
         } else {
            var7 = var1.method2641(!var5.method2941(var2) & !var6.method2941(var4));
            var7.method2647(var5, var2, var6, var4, this.interleaveLeave);
            return var7;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Leb;III)Leb;",
      garbageValue = "-307040108"
   )
   Model method4811(Model var1, int var2, int var3) {
      var2 = this.frameIDs[var2];
      Frames var4 = GraphicsObject.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var4 == null) {
         return var1.method2641(true);
      } else {
         Model var5 = var1.method2641(!var4.method2941(var2));
         var3 &= 3;
         if(var3 == 1) {
            var5.method2603();
         } else if(var3 == 2) {
            var5.method2602();
         } else if(var3 == 3) {
            var5.method2656();
         }

         var5.method2639(var4, var2);
         if(var3 == 1) {
            var5.method2656();
         } else if(var3 == 2) {
            var5.method2602();
         } else if(var3 == 3) {
            var5.method2603();
         }

         return var5;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Leb;IB)Leb;",
      garbageValue = "117"
   )
   Model method4785(Model var1, int var2) {
      var2 = this.frameIDs[var2];
      Frames var3 = GraphicsObject.getFrames(var2 >> 16);
      var2 &= 65535;
      if(var3 == null) {
         return var1.method2591(true);
      } else {
         Model var4 = var1.method2591(!var3.method2941(var2));
         var4.method2639(var3, var2);
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Leb;IS)Leb;",
      garbageValue = "-24046"
   )
   public Model method4802(Model var1, int var2) {
      int var3 = this.frameIDs[var2];
      Frames var4 = GraphicsObject.getFrames(var3 >> 16);
      var3 &= 65535;
      if(var4 == null) {
         return var1.method2641(true);
      } else {
         Frames var5 = null;
         int var6 = 0;
         if(this.field3609 != null && var2 < this.field3609.length) {
            var6 = this.field3609[var2];
            var5 = GraphicsObject.getFrames(var6 >> 16);
            var6 &= 65535;
         }

         Model var7;
         if(var5 != null && var6 != 65535) {
            var7 = var1.method2641(!var4.method2941(var3) & !var5.method2941(var6));
            var7.method2639(var4, var3);
            var7.method2639(var5, var6);
            return var7;
         } else {
            var7 = var1.method2641(!var4.method2941(var3));
            var7.method2639(var4, var3);
            return var7;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "38"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "1924863143"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4781(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;II)I",
      garbageValue = "-1559208129"
   )
   public static int method4782(CharSequence var0, int var1) {
      return class41.parseInt(var0, var1, true);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "-111"
   )
   public static boolean method4813(char var0) {
      return var0 >= ' ' && var0 <= '~'?true:(var0 >= 160 && var0 <= 255?true:var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376);
   }
}
