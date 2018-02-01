import java.awt.Image;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("ISAACCipher")
public final class ISAACCipher {
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field2525;
   @ObfuscatedName("ai")
   static Image field2516;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 177743925
   )
   @Export("valuesRemaining")
   int valuesRemaining;
   @ObfuscatedName("j")
   @Export("randResult")
   int[] randResult;
   @ObfuscatedName("a")
   @Export("mm")
   int[] mm;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -285264015
   )
   int field2521;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 431748801
   )
   int field2522;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1316008237
   )
   int field2523;

   public ISAACCipher(int[] var1) {
      this.mm = new int[256];
      this.randResult = new int[256];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.randResult[var2] = var1[var2];
      }

      this.method3686();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-279053551"
   )
   @Export("nextInt")
   final int nextInt() {
      if(0 == --this.valuesRemaining + 1) {
         this.generateMoreResults();
         this.valuesRemaining = 255;
      }

      return this.randResult[this.valuesRemaining];
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "1205"
   )
   final int method3684() {
      if(this.valuesRemaining == 0) {
         this.generateMoreResults();
         this.valuesRemaining = 256;
      }

      return this.randResult[this.valuesRemaining - 1];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1721007371"
   )
   @Export("generateMoreResults")
   final void generateMoreResults() {
      this.field2522 += ++this.field2523;

      for(int var1 = 0; var1 < 256; ++var1) {
         int var2 = this.mm[var1];
         if((var1 & 2) == 0) {
            if((var1 & 1) == 0) {
               this.field2521 ^= this.field2521 << 13;
            } else {
               this.field2521 ^= this.field2521 >>> 6;
            }
         } else if((var1 & 1) == 0) {
            this.field2521 ^= this.field2521 << 2;
         } else {
            this.field2521 ^= this.field2521 >>> 16;
         }

         this.field2521 += this.mm[128 + var1 & 255];
         int var3;
         this.mm[var1] = var3 = this.mm[(var2 & 1020) >> 2] + this.field2522 + this.field2521;
         this.randResult[var1] = this.field2522 = this.mm[(var3 >> 8 & 1020) >> 2] + var2;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-757711774"
   )
   final void method3686() {
      int var9 = -1640531527;
      int var8 = -1640531527;
      int var7 = -1640531527;
      int var6 = -1640531527;
      int var5 = -1640531527;
      int var4 = -1640531527;
      int var3 = -1640531527;
      int var2 = -1640531527;

      int var1;
      for(var1 = 0; var1 < 4; ++var1) {
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.randResult[var1];
         var3 += this.randResult[var1 + 1];
         var4 += this.randResult[var1 + 2];
         var5 += this.randResult[var1 + 3];
         var6 += this.randResult[var1 + 4];
         var7 += this.randResult[var1 + 5];
         var8 += this.randResult[var1 + 6];
         var9 += this.randResult[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      for(var1 = 0; var1 < 256; var1 += 8) {
         var2 += this.mm[var1];
         var3 += this.mm[var1 + 1];
         var4 += this.mm[var1 + 2];
         var5 += this.mm[var1 + 3];
         var6 += this.mm[var1 + 4];
         var7 += this.mm[var1 + 5];
         var8 += this.mm[var1 + 6];
         var9 += this.mm[var1 + 7];
         var2 ^= var3 << 11;
         var5 += var2;
         var3 += var4;
         var3 ^= var4 >>> 2;
         var6 += var3;
         var4 += var5;
         var4 ^= var5 << 8;
         var7 += var4;
         var5 += var6;
         var5 ^= var6 >>> 16;
         var8 += var5;
         var6 += var7;
         var6 ^= var7 << 10;
         var9 += var6;
         var7 += var8;
         var7 ^= var8 >>> 4;
         var2 += var7;
         var8 += var9;
         var8 ^= var9 << 8;
         var3 += var8;
         var9 += var2;
         var9 ^= var2 >>> 9;
         var4 += var9;
         var2 += var3;
         this.mm[var1] = var2;
         this.mm[var1 + 1] = var3;
         this.mm[var1 + 2] = var4;
         this.mm[var1 + 3] = var5;
         this.mm[var1 + 4] = var6;
         this.mm[var1 + 5] = var7;
         this.mm[var1 + 6] = var8;
         this.mm[var1 + 7] = var9;
      }

      this.generateMoreResults();
      this.valuesRemaining = 256;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "660410707"
   )
   protected static int method3691() {
      int var0 = 0;
      if(UrlRequester.field2068 == null || !UrlRequester.field2068.isValid()) {
         try {
            Iterator var1 = ManagementFactory.getGarbageCollectorMXBeans().iterator();

            while(var1.hasNext()) {
               GarbageCollectorMXBean var2 = (GarbageCollectorMXBean)var1.next();
               if(var2.isValid()) {
                  UrlRequester.field2068 = var2;
                  GameEngine.garbageCollectorLastCheckTimeMs = -1L;
                  GameEngine.garbageCollectorLastCollectionTime = -1L;
               }
            }
         } catch (Throwable var11) {
            ;
         }
      }

      if(UrlRequester.field2068 != null) {
         long var9 = ScriptVarType.currentTimeMs();
         long var3 = UrlRequester.field2068.getCollectionTime();
         if(GameEngine.garbageCollectorLastCollectionTime != -1L) {
            long var5 = var3 - GameEngine.garbageCollectorLastCollectionTime;
            long var7 = var9 - GameEngine.garbageCollectorLastCheckTimeMs;
            if(var7 != 0L) {
               var0 = (int)(100L * var5 / var7);
            }
         }

         GameEngine.garbageCollectorLastCollectionTime = var3;
         GameEngine.garbageCollectorLastCheckTimeMs = var9;
      }

      return var0;
   }

   @ObfuscatedName("kg")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Ljava/lang/String;",
      garbageValue = "-271169034"
   )
   static String method3697(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.socketType == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.socketType == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.socketType == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.socketType == 5) {
         var0 = var0 + "-wti";
      } else if(Client.socketType == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(class61.sessionToken != null) {
         var3 = "/p=" + class61.sessionToken;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.languageId + "/a=" + class150.field2081 + var3 + "/";
   }
}
