import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("ds")
public class class111 {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2117383449
   )
   public static int field1588;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   HashTable field1585;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgn;"
   )
   HashTable field1587;

   @ObfuscatedSignature(
      signature = "(Lid;Lid;)V"
   )
   public class111(IndexDataBase var1, IndexDataBase var2) {
      this.field1585 = new HashTable(256);
      this.field1587 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II[II)Lda;",
      garbageValue = "2096653639"
   )
   class106 method2180(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class106 var7 = (class106)this.field1587.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2013();
            this.field1587.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.field1527.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II[II)Lda;",
      garbageValue = "-397729554"
   )
   class106 method2181(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class106 var7 = (class106)this.field1587.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class105 var8 = (class105)this.field1585.get(var5);
         if(var8 == null) {
            var8 = class105.method2037(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1585.put(var8, var5);
         }

         var7 = var8.method2054(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1587.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I[II)Lda;",
      garbageValue = "2112552608"
   )
   public class106 method2182(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2180(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2180(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I[II)Lda;",
      garbageValue = "-1893165329"
   )
   public class106 method2185(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2181(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2181(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIIIIII)I",
      garbageValue = "1413919875"
   )
   public static int method2195(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgv;B)V",
      garbageValue = "4"
   )
   @Export("encodeClassVerifier")
   public static void encodeClassVerifier(PacketBuffer var0) {
      ClassInfo var1 = (ClassInfo)class289.classInfos.last();
      if(var1 != null) {
         int var2 = var0.offset;
         var0.putInt(var1.field3795);

         for(int var3 = 0; var3 < var1.count; ++var3) {
            if(var1.errorIdentifiers[var3] != 0) {
               var0.putByte(var1.errorIdentifiers[var3]);
            } else {
               try {
                  int var4 = var1.type[var3];
                  Field var5;
                  int var6;
                  if(var4 == 0) {
                     var5 = var1.fields[var3];
                     var6 = Reflection.getInt(var5, (Object)null);
                     var0.putByte(0);
                     var0.putInt(var6);
                  } else if(var4 == 1) {
                     var5 = var1.fields[var3];
                     Reflection.setInt(var5, (Object)null, var1.field3798[var3]);
                     var0.putByte(0);
                  } else if(var4 == 2) {
                     var5 = var1.fields[var3];
                     var6 = var5.getModifiers();
                     var0.putByte(0);
                     var0.putInt(var6);
                  }

                  Method var25;
                  if(var4 != 3) {
                     if(var4 == 4) {
                        var25 = var1.methods[var3];
                        var6 = var25.getModifiers();
                        var0.putByte(0);
                        var0.putInt(var6);
                     }
                  } else {
                     var25 = var1.methods[var3];
                     byte[][] var10 = var1.args[var3];
                     Object[] var7 = new Object[var10.length];

                     for(int var8 = 0; var8 < var10.length; ++var8) {
                        ObjectInputStream var9 = new ObjectInputStream(new ByteArrayInputStream(var10[var8]));
                        var7[var8] = var9.readObject();
                     }

                     Object var11 = Reflection.invoke(var25, (Object)null, var7);
                     if(var11 == null) {
                        var0.putByte(0);
                     } else if(var11 instanceof Number) {
                        var0.putByte(1);
                        var0.putLong(((Number)var11).longValue());
                     } else if(var11 instanceof String) {
                        var0.putByte(2);
                        var0.putString((String)var11);
                     } else {
                        var0.putByte(4);
                     }
                  }
               } catch (ClassNotFoundException var13) {
                  var0.putByte(-10);
               } catch (InvalidClassException var14) {
                  var0.putByte(-11);
               } catch (StreamCorruptedException var15) {
                  var0.putByte(-12);
               } catch (OptionalDataException var16) {
                  var0.putByte(-13);
               } catch (IllegalAccessException var17) {
                  var0.putByte(-14);
               } catch (IllegalArgumentException var18) {
                  var0.putByte(-15);
               } catch (InvocationTargetException var19) {
                  var0.putByte(-16);
               } catch (SecurityException var20) {
                  var0.putByte(-17);
               } catch (IOException var21) {
                  var0.putByte(-18);
               } catch (NullPointerException var22) {
                  var0.putByte(-19);
               } catch (Exception var23) {
                  var0.putByte(-20);
               } catch (Throwable var24) {
                  var0.putByte(-21);
               }
            }
         }

         var0.putCrc(var2);
         var1.unlink();
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "50227379"
   )
   public static boolean method2196(int var0) {
      return var0 >= class228.field2892.field2908 && var0 <= class228.field2888.field2908 || var0 == class228.field2889.field2908;
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-598935919"
   )
   static final void method2179() {
      if(Client.field1108 > 0) {
         Renderable.method2993();
      } else {
         Client.field919.method5095();
         WorldComparator.setGameState(40);
         FileOnDisk.field1685 = Client.field916.getSocket();
         Client.field916.method1939();
      }
   }
}
