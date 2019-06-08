import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

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
   @Export("indexCache")
   AbstractIndexCache indexCache;

   @ObfuscatedSignature(
      signature = "(Lir;Lir;IDI)V"
   )
   public TextureProvider(AbstractIndexCache var1, AbstractIndexCache var2, int var3, double var4, int var6) {
      this.deque = new NodeDeque();
      this.remaining = 0;
      this.brightness0 = 1.0D;
      this.textureSize = 128;
      this.indexCache = var2;
      this.capacity = var3;
      this.remaining = this.capacity;
      this.brightness0 = var4;
      this.textureSize = var6;
      int[] var7 = var1.__j_395(0);
      int var8 = var7.length;
      this.textures = new Texture[var1.__s_396(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.takeRecord(0, var7[var9]));
         this.textures[var7[var9]] = new Texture(var10);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1996487053"
   )
   @Export("__m_212")
   public int __m_212() {
      int var1 = 0;
      int var2 = 0;
      Texture[] var3 = this.textures;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         Texture var5 = var3[var4];
         if(var5 != null && var5.records != null) {
            var1 += var5.records.length;
            int[] var6 = var5.records;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               int var8 = var6[var7];
               if(this.indexCache.__u_393(var8)) {
                  ++var2;
               }
            }
         }
      }

      if(var1 == 0) {
         return 0;
      } else {
         return var2 * 100 / var1;
      }
   }

   @ObfuscatedName("f")
   @Export("setBrightness")
   public void setBrightness(double var1) {
      this.brightness0 = var1;
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
      if(var2 != null) {
         if(var2.pixels != null) {
            this.deque.addLast(var2);
            var2.isLoaded = true;
            return var2.pixels;
         }

         boolean var3 = var2.__m_230(this.brightness0, this.textureSize, this.indexCache);
         if(var3) {
            if(this.remaining == 0) {
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
   @Export("__w_213")
   public int __w_213(int var1) {
      return this.textures[var1] != null?this.textures[var1].int1:0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "14"
   )
   @Export("__o_214")
   public boolean __o_214(int var1) {
      return this.textures[var1].__u;
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
      for(int var1 = 0; var1 < this.textures.length; ++var1) {
         if(this.textures[var1] != null) {
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
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if(var3 != null && var3.animationDirection != 0 && var3.isLoaded) {
            var3.Texture_animate(var1);
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
      var0.index += class303.huffman.__m_293(var3, 0, var3.length, var0.array, var0.index);
      return var0.index - var2;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZB)[B",
      garbageValue = "-8"
   )
   @Export("byteArrayFromObject")
   public static byte[] byteArrayFromObject(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteArrayCopier) {
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

      label69:
      while(true) {
         int var6 = var4.__at_308();
         if(var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.__ae_307();
               if(var9 == 0) {
                  continue label69;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if(var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectDefinition var15 = class50.getObjectDefinition(var5);
                  if(var12 != 22 || !Client.isLowDetail || var15.int1 != 0 || var15.interactType == 1 || var15.boolean2) {
                     if(!var15.__g_422()) {
                        ++Client.__client_fk;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.__ae_307();
            if(var9 == 0) {
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
      if(var0 == 4000) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 + var4;
         return 1;
      } else if(var0 == 4001) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 - var4;
         return 1;
      } else if(var0 == 4002) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var4 * var3;
         return 1;
      } else if(var0 == 4003) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 / var4;
         return 1;
      } else if(var0 == 4004) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if(var0 == 4005) {
         var3 = Interpreter.Interpreter_intStack[--class179.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else if(var0 == 4006) {
         class179.Interpreter_intStackSize -= 5;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         int var5 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
         int var6 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 3];
         int var7 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 4];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
         return 1;
      } else if(var0 == 4007) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 + var3 * var4 / 100;
         return 1;
      } else if(var0 == 4008) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 | 1 << var4;
         return 1;
      } else if(var0 == 4009) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
         return 1;
      } else if(var0 == 4010) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0?1:0;
         return 1;
      } else if(var0 == 4011) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 % var4;
         return 1;
      } else if(var0 == 4012) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         if(var3 == 0) {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
         } else {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
         }

         return 1;
      } else if(var0 == 4013) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         if(var3 == 0) {
            Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = 0;
            return 1;
         } else {
            switch(var4) {
            case 0:
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
               break;
            case 1:
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3;
               break;
            case 2:
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
               break;
            case 3:
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
               break;
            case 4:
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
               break;
            default:
               Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
            }

            return 1;
         }
      } else if(var0 == 4014) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 & var4;
         return 1;
      } else if(var0 == 4015) {
         class179.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = var3 | var4;
         return 1;
      } else if(var0 == 4018) {
         class179.Interpreter_intStackSize -= 3;
         long var9 = (long)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize];
         long var11 = (long)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 1];
         long var13 = (long)Interpreter.Interpreter_intStack[class179.Interpreter_intStackSize + 2];
         Interpreter.Interpreter_intStack[++class179.Interpreter_intStackSize - 1] = (int)(var13 * var9 / var11);
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

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].clear();
      }

      System.gc();
      AbstractSocket.method3488(2);
      Client.__client_qy = -1;
      Client.__client_qq = false;
      SpriteMask.method4390();
      GameShell.updateGameState(10);
   }
}
