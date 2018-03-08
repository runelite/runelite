import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("MapIconReference")
public class MapIconReference {
   @ObfuscatedName("en")
   @ObfuscatedSignature(
      signature = "Lec;"
   )
   @Export("urlRequester")
   static UrlRequester urlRequester;
   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static Widget field574;
   @ObfuscatedName("jy")
   @ObfuscatedGetter(
      intValue = 1362734343
   )
   static int field571;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1987459455
   )
   @Export("areaId")
   public int areaId;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public Coordinates field568;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public Coordinates field570;

   @ObfuscatedSignature(
      signature = "(ILik;Lik;)V"
   )
   public MapIconReference(int var1, Coordinates var2, Coordinates var3) {
      this.areaId = var1;
      this.field568 = var2;
      this.field570 = var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-208102625"
   )
   static int method758(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "119384102"
   )
   static int method759(int var0) {
      ChatLineBuffer var1 = (ChatLineBuffer)class95.chatLineMap.get(Integer.valueOf(var0));
      return var1 == null?0:var1.size();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "-62"
   )
   static final void method757(String var0) {
      TotalQuantityComparator.sendGameMessage(30, "", var0);
   }

   @ObfuscatedName("jw")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "80"
   )
   static final void method760() {
      Client.field1039 = Client.cycleCntr;
   }
}
