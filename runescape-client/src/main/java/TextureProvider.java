import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("dl")
@Implements("TextureProvider")
public class TextureProvider implements TextureLoader {
   @ObfuscatedName("af")
   @Export("client")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client client;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Ldh;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   @Export("deque")
   NodeDeque deque;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 762273989
   )
   @Export("capacity")
   int capacity;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1130378699
   )
   @Export("remaining")
   int remaining;
   @ObfuscatedName("o")
   @Export("brightness0")
   double brightness0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1124790219
   )
   @Export("textureSize")
   int textureSize;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("archive")
   AbstractArchive archive;

   @ObfuscatedSignature(
      signature = "(Lir;Lir;IDI)V"
   )
   public TextureProvider(AbstractArchive var1, AbstractArchive var2, int var3, double var4, int var6) {
      this.deque = new NodeDeque();
      this.remaining = 0;
      this.brightness0 = 1.0D;
      this.textureSize = 128;
      this.archive = var2;
      this.capacity = var3;
      this.remaining = this.capacity;
      this.brightness0 = var4;
      this.textureSize = var6;
      int[] var7 = var1.method3(0);
      int var8 = var7.length;
      this.textures = new Texture[var1.method4(0)];

      for (int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.takeFile(0, var7[var9]));
         this.textures[var7[var9]] = new Texture(var10);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1996487053"
   )
   public int method323() {
      int var1 = 0;
      int var2 = 0;
      Texture[] var3 = this.textures;

      for (int var4 = 0; var4 < var3.length; ++var4) {
         Texture var5 = var3[var4];
         if (var5 != null && var5.records != null) {
            var1 += var5.records.length;
            int[] var6 = var5.records;

            for (int var7 = 0; var7 < var6.length; ++var7) {
               int var8 = var6[var7];
               if (this.archive.method1(var8)) {
                  ++var2;
               }
            }
         }
      }

      if (var1 == 0) {
         return 0;
      } else {
         return var2 * 100 / var1;
      }
   }

   @ObfuscatedName("f")
   @Export("setBrightness")
   public void setBrightness(double brightness) {
      this.brightness0 = brightness;
      this.clear();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)[I",
      garbageValue = "-905309626"
   )
   @Export("load")
   public int[] load(int var1) {
      Texture var2 = this.textures[var1];
      if (var2 != null) {
         if (var2.pixels != null) {
            this.deque.addLast(var2);
            var2.isLoaded = true;
            return var2.pixels;
         }

         boolean var3 = var2.method320(this.brightness0, this.textureSize, this.archive);
         if (var3) {
            if (this.remaining == 0) {
               Texture var4 = (Texture)this.deque.removeFirst();
               var4.reset();
            } else {
               --this.remaining;
            }

            this.deque.addLast(var2);
            var2.isLoaded = true;
            return var2.pixels;
         }
      }

      return null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1641984961"
   )
   public int vmethod324(int var1) {
      return this.textures[var1] != null ? this.textures[var1].int1 : 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "14"
   )
   public boolean vmethod325(int var1) {
      return this.textures[var1].field893;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1427873761"
   )
   @Export("isLowDetail")
   public boolean isLowDetail(int var1) {
      return this.textureSize == 64;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-692582552"
   )
   @Export("clear")
   public void clear() {
      for (int var1 = 0; var1 < this.textures.length; ++var1) {
         if (this.textures[var1] != null) {
            this.textures[var1].reset();
         }
      }

      this.deque = new NodeDeque();
      this.remaining = this.capacity;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1044108445"
   )
   @Export("animate")
   public void animate(int var1) {
      for (int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if (var3 != null && var3.animationDirection != 0 && var3.isLoaded) {
            var3.animate(var1);
            var3.isLoaded = false;
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgr;Ljava/lang/String;B)I",
      garbageValue = "16"
   )
   public static int method2777(Buffer var0, String var1) {
      int var2 = var0.index;
      byte[] var3 = class230.method4516(var1);
      var0.writeSmartByteShort(var3.length);
      var0.index += class303.huffman.method127(var3, 0, var3.length, var0.array, var0.index);
      return var0.index - var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "-8"
   )
   @Export("byteArrayFromObject")
   public static byte[] byteArrayFromObject(Object var0, boolean copyArray) {
      if (var0 == null) {
         return null;
      } else if (var0 instanceof byte[]) {
         byte[] var5 = ((byte[])var0);
         if (copyArray) {
            int var3 = var5.length;
            byte[] var4 = new byte[var3];
            System.arraycopy(var5, 0, var4, 0, var3);
            return var4;
         } else {
            return var5;
         }
      } else if (var0 instanceof AbstractByteArrayCopier) {
         AbstractByteArrayCopier var2 = (AbstractByteArrayCopier)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIIB)Z",
      garbageValue = "1"
   )
   static final boolean method2774(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label56:
      while (true) {
         int var6 = var4.method49();
         if (var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while (true) {
            int var13;
            while (!var8) {
               var13 = var4.method48();
               if (var13 == 0) {
                  continue label56;
               }

               var7 += var13 - 1;
               int var14 = var7 & 63;
               int var15 = var7 >> 6 & 63;
               int var9 = var4.readUnsignedByte() >> 2;
               int var11 = var15 + var1;
               int var12 = var14 + var2;
               if (var11 > 0 && var12 > 0 && var11 < 103 && var12 < 103) {
                  ObjectDefinition var10 = class50.getObjectDefinition(var5);
                  if (var9 != 22 || !Client.isLowDetail || var10.int1 != 0 || var10.interactType == 1 || var10.boolean2) {
                     if (!var10.method231()) {
                        ++Client.field179;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var13 = var4.method48();
            if (var13 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(ILcg;ZI)I",
      garbageValue = "-1177246760"
   )
   static int method2752(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if (var0 == ScriptOpcodes.ADD) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 + var4;
         return 1;
      } else if (var0 == ScriptOpcodes.SUB) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 - var4;
         return 1;
      } else if (var0 == ScriptOpcodes.MULTIPLY) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var4 * var3;
         return 1;
      } else if (var0 == ScriptOpcodes.DIV) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 / var4;
         return 1;
      } else if (var0 == ScriptOpcodes.RANDOM) {
         var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if (var0 == ScriptOpcodes.RANDOMINC) {
         var3 = Interpreter.Interpreter_intStack[--RouteStrategy.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if (var0 == ScriptOpcodes.INTERPOLATE) {
         RouteStrategy.Interpreter_intStackSize -= 5;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         int var11 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 2];
         int var6 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 3];
         int var12 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 4];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 + (var12 - var11) * (var4 - var3) / (var6 - var11);
         return 1;
      } else if (var0 == ScriptOpcodes.ADDPERCENT) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if (var0 == ScriptOpcodes.SETBIT) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if (var0 == ScriptOpcodes.CLEARBIT) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if (var0 == ScriptOpcodes.TESTBIT) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
         return 1;
      } else if (var0 == ScriptOpcodes.MOD) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 % var4;
         return 1;
      } else if (var0 == ScriptOpcodes.POW) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         if (var3 == 0) {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
         } else {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if (var0 == ScriptOpcodes.INVPOW) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         if (var3 == 0) {
            Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = 0;
            return 1;
         } else {
            switch(var4) {
            case 0:
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3;
               break;
            case 2:
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
               break;
            case 3:
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
               break;
            case 4:
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
               break;
            default:
               Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
            }

            return 1;
         }
      } else if (var0 == ScriptOpcodes.AND) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 & var4;
         return 1;
      } else if (var0 == ScriptOpcodes.OR) {
         RouteStrategy.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = var3 | var4;
         return 1;
      } else if (var0 == ScriptOpcodes.SCALE) {
         RouteStrategy.Interpreter_intStackSize -= 3;
         long var5 = (long)Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize];
         long var7 = (long)Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 1];
         long var9 = (long)Interpreter.Interpreter_intStack[RouteStrategy.Interpreter_intStackSize + 2];
         Interpreter.Interpreter_intStack[++RouteStrategy.Interpreter_intStackSize - 1] = (int)(var9 * var5 / var7);
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-853047987"
   )
   static final void method2773() {
      Client.packetWriter.close();
      FontName.method5641();
      class65.scene.clear();

      for (int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].clear();
      }

      System.gc();
      AbstractSocket.method3488(2);
      Client.field112 = -1;
      Client.field107 = false;
      SpriteMask.method4390();
      GameShell.updateGameState(10);
   }
}
