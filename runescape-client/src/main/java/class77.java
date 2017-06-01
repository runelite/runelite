import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class77 {
   @ObfuscatedName("e")
   class153 field1229;
   @ObfuscatedName("y")
   byte[] field1230;
   @ObfuscatedName("v")
   DataInputStream field1231;
   @ObfuscatedName("i")
   byte[] field1232;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1508227533
   )
   int field1234;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -841714091
   )
   int field1235;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 787236665
   )
   int field1236;
   @ObfuscatedName("a")
   static ModIcon field1237;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -53969428926690331L
   )
   long field1239;
   @ObfuscatedName("of")
   @Export("clanMembers")
   static XClanMember[] clanMembers;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)[B",
      garbageValue = "1075661198"
   )
   byte[] method1507() throws IOException {
      if(XGrandExchangeOffer.method96() > this.field1239) {
         throw new IOException();
      } else {
         if(this.field1236 == 0) {
            if(this.field1229.field2244 == 2) {
               throw new IOException();
            }

            if(this.field1229.field2244 == 1) {
               this.field1231 = (DataInputStream)this.field1229.field2248;
               this.field1236 = 1;
            }
         }

         if(this.field1236 == 1) {
            this.field1234 += this.field1231.read(this.field1232, this.field1234, this.field1232.length - this.field1234);
            if(this.field1234 == 4) {
               int var1 = (new Buffer(this.field1232)).readInt();
               this.field1230 = new byte[var1];
               this.field1236 = 2;
            }
         }

         if(this.field1236 == 2) {
            this.field1235 += this.field1231.read(this.field1230, this.field1235, this.field1230.length - this.field1235);
            if(this.field1235 == this.field1230.length) {
               return this.field1230;
            }
         }

         return null;
      }
   }

   class77(class154 var1, URL var2) {
      this.field1232 = new byte[4];
      this.field1229 = var1.method2954(var2);
      this.field1236 = 0;
      this.field1239 = XGrandExchangeOffer.method96() + 30000L;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LModel;IB)V",
      garbageValue = "-1"
   )
   public static final void method1511(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.field1945; ++var2) {
         if(var0.field1951[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.field1978[var3];
            int var7 = Model.field1978[var4];
            int var8 = Model.field1978[var5];
            int var9 = Model.field1979[var3];
            int var10 = Model.field1979[var4];
            int var11 = Model.field1979[var5];
            int var12 = Math.min(var6, Math.min(var7, var8)) - var1;
            int var13 = Math.max(var6, Math.max(var7, var8)) + var1;
            int var14 = Math.min(var9, Math.min(var10, var11)) - var1;
            int var15 = Math.max(var9, Math.max(var10, var11)) + var1;
            class59.method966(var12, var14, var13, var15, -49088);
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "99"
   )
   static int method1512(int var0, int var1) {
      XItemContainer var2 = (XItemContainer)XItemContainer.itemContainers.method3520((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.stackSizes.length?var2.stackSizes[var1]:0);
   }
}
