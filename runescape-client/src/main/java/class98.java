import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
public class class98 {
   @ObfuscatedName("pp")
   @ObfuscatedGetter(
      intValue = 111368081
   )
   static int field1360;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("sfx_index")
   IndexDataBase sfx_index;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("vorbis_index")
   IndexDataBase vorbis_index;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   HashTable field1359;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   HashTable field1357;

   @ObfuscatedSignature(
      signature = "(Liv;Liv;)V"
   )
   public class98(IndexDataBase var1, IndexDataBase var2) {
      this.field1359 = new HashTable(256);
      this.field1357 = new HashTable(256);
      this.sfx_index = var1;
      this.vorbis_index = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II[IB)Lcg;",
      garbageValue = "-33"
   )
   RawAudioNode method2275(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      RawAudioNode var7 = (RawAudioNode)this.field1357.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         SoundEffect var8 = SoundEffect.getTrack(this.sfx_index, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method2110();
            this.field1357.put(var7, var5);
            if(var3 != null) {
               var3[0] -= var7.audioBuffer.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[II)Lcg;",
      garbageValue = "722390321"
   )
   RawAudioNode method2276(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & 65535 | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      RawAudioNode var7 = (RawAudioNode)this.field1357.get(var5);
      if(var7 != null) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class92 var8 = (class92)this.field1359.get(var5);
         if(var8 == null) {
            var8 = class92.getInstrument(this.vorbis_index, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1359.put(var8, var5);
         }

         var7 = var8.method2128(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1357.put(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[II)Lcg;",
      garbageValue = "-757008929"
   )
   public RawAudioNode method2277(int var1, int[] var2) {
      if(this.sfx_index.size() == 1) {
         return this.method2275(0, var1, var2);
      } else if(this.sfx_index.fileCount(var1) == 1) {
         return this.method2275(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I[II)Lcg;",
      garbageValue = "1692568928"
   )
   public RawAudioNode method2274(int var1, int[] var2) {
      if(this.vorbis_index.size() == 1) {
         return this.method2276(0, var1, var2);
      } else if(this.vorbis_index.fileCount(var1) == 1) {
         return this.method2276(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-12"
   )
   public static int method2288(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ILcs;ZI)I",
      garbageValue = "-1370748959"
   )
   static int method2285(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = OwnWorldComparator.getWidget(class69.intStack[--class45.intStackSize]);
      } else {
         var3 = var2?class184.field2379:FriendManager.field996;
      }

      if(var0 == 1927) {
         if(class69.field1025 >= 10) {
            throw new RuntimeException();
         } else if(var3.onResizeListener == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.source = var3;
            var4.params = var3.onResizeListener;
            var4.field519 = class69.field1025 + 1;
            Client.field755.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("id")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
      garbageValue = "105"
   )
   static final void method2289(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            Client.menuBooleanArray[Client.menuOptionCount] = var6;
            ++Client.menuOptionCount;
         }

      }
   }
}
